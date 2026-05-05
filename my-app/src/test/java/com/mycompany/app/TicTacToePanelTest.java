package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.GridLayout;
import javax.swing.JButton;
import org.junit.jupiter.api.Test;

class TicTacToePanelTest {
    @Test
    void clickingCellFillsItAndTriggersComputerMove() {
        System.setProperty("java.awt.headless", "true");

        TicTacToePanel panel = new TicTacToePanel(new GridLayout(3, 3));
        JButton first = (JButton) panel.getComponent(0);
        assertEquals(" ", first.getText());

        first.doClick();

        assertEquals("X", first.getText());

        int filled = 0;
        for (int i = 0; i < panel.getComponentCount(); i++) {
            JButton b = (JButton) panel.getComponent(i);
            if (!" ".equals(b.getText())) {
                filled++;
            }
        }
        assertEquals(2, filled);
    }
}

