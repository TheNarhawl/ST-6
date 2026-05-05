package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class UtilityTest {
    @Test
    void printsCharBoard() {
        char[] b = {'X', 'O', 'X', ' ', ' ', ' ', 'O', 'X', 'O'};
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(baos));
        try {
            Utility.print(b);
        } finally {
            System.setOut(old);
        }
        String s = baos.toString();
        assertTrue(s.contains("X-"));
        assertTrue(s.contains("O-"));
    }

    @Test
    void printsIntBoard() {
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(baos));
        try {
            Utility.print(b);
        } finally {
            System.setOut(old);
        }
        assertTrue(baos.toString().contains("1-"));
    }

    @Test
    void printsMovesList() {
        ArrayList<Integer> moves = new ArrayList<>();
        moves.add(0);
        moves.add(4);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(baos));
        try {
            Utility.print(moves);
        } finally {
            System.setOut(old);
        }
        String s = baos.toString();
        assertTrue(s.contains("0-"));
        assertTrue(s.contains("4-"));
    }
}

