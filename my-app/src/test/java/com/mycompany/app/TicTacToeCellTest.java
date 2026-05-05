package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTacToeCellTest {
    @Test
    void cellStoresCoordinatesAndMarker() {
        TicTacToeCell c = new TicTacToeCell(5, 2, 1);
        assertEquals(5, c.getNum());
        assertEquals(1, c.getRow());
        assertEquals(2, c.getCol());
        assertEquals(' ', c.getMarker());

        c.setMarker("X");
        assertEquals('X', c.getMarker());
        assertFalse(c.isEnabled());
        assertEquals("X", c.getText());
    }
}

