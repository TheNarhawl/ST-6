package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    void checkStateDetectsXWinRow() {
        Game g = new Game();
        g.symbol = 'X';
        char[] b = {
                'X', 'X', 'X',
                ' ', 'O', ' ',
                'O', ' ', ' '
        };
        assertEquals(State.XWIN, g.checkState(b));
    }

    @Test
    void checkStateDetectsOWinDiagonal() {
        Game g = new Game();
        g.symbol = 'O';
        char[] b = {
                'O', 'X', 'X',
                ' ', 'O', ' ',
                'X', ' ', 'O'
        };
        assertEquals(State.OWIN, g.checkState(b));
    }

    @Test
    void checkStateDetectsDraw() {
        Game g = new Game();
        g.symbol = 'X';
        char[] b = {
                'X', 'O', 'X',
                'X', 'O', 'O',
                'O', 'X', 'X'
        };
        assertEquals(State.DRAW, g.checkState(b));
    }

    @Test
    void checkStateDetectsPlaying() {
        Game g = new Game();
        g.symbol = 'O';
        char[] b = {
                'X', 'O', 'X',
                ' ', 'O', ' ',
                ' ', 'X', ' '
        };
        assertEquals(State.PLAYING, g.checkState(b));
    }

    @Test
    void generateMovesFindsEmptyCells() {
        Game g = new Game();
        char[] b = {
                'X', 'O', 'X',
                ' ', 'O', ' ',
                ' ', 'X', ' '
        };
        ArrayList<Integer> moves = new ArrayList<>();
        g.generateMoves(b, moves);
        assertEquals(4, moves.size());
        assertTrue(moves.contains(3));
        assertTrue(moves.contains(5));
        assertTrue(moves.contains(6));
        assertTrue(moves.contains(8));
    }

    @Test
    void evaluatePositionReturnsInfForWinningPlayer() {
        Game g = new Game();
        Player x = new Player();
        x.symbol = 'X';
        g.symbol = 'X';
        char[] b = {
                'X', 'X', 'X',
                'O', 'O', ' ',
                ' ', ' ', ' '
        };
        assertEquals(Game.INF, g.evaluatePosition(b, x));
    }

    @Test
    void evaluatePositionReturnsMinusInfForLosingPlayer() {
        Game g = new Game();
        Player o = new Player();
        o.symbol = 'O';
        g.symbol = 'X';
        char[] b = {
                'X', 'X', 'X',
                'O', 'O', ' ',
                ' ', ' ', ' '
        };
        assertEquals(-Game.INF, g.evaluatePosition(b, o));
    }

    @Test
    void miniMaxChoosesImmediateWin() {
        Game g = new Game();
        Player o = g.player2;
        char[] b = {
                'O', 'O', ' ',
                'X', 'X', ' ',
                ' ', ' ', ' '
        };
        int move = g.MiniMax(b, o);
        assertEquals(3, move);
    }

    @Test
    void minAndMaxMoveTerminateOnTerminalStates() {
        Game g = new Game();
        Player x = g.player1;
        g.symbol = 'X';
        char[] win = {
                'X', 'X', 'X',
                'O', 'O', ' ',
                ' ', ' ', ' '
        };
        assertEquals(Game.INF, g.MinMove(win, x));
        assertEquals(Game.INF, g.MaxMove(win, x));
    }
}

