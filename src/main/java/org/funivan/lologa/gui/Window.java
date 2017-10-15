package org.funivan.lologa.gui;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(GamePanel board) {
        this.setTitle("Game Lolo GA");
        this.setSize(800, 800);
        this.setLayout(
            new BorderLayout(0, 0)
        );

        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.add(board);
        this.setVisible(true);
    }

}
