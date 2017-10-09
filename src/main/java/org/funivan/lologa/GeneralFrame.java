package org.funivan.lologa;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GeneralFrame extends JFrame {
    public GeneralFrame(Iterable<Color> colors) throws IOException {
        this.setTitle("Game Lolo GA");
        this.setSize(600, 600);
        this.setLayout(
            new BorderLayout(50, 50)
        );
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.add(
            new Board(colors)
        );
        this.setVisible(true);

    }

}
