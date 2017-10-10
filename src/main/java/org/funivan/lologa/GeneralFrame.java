package org.funivan.lologa;

import org.funivan.lologa.tile.TilesPool.TilesPool;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GeneralFrame extends JFrame {
    public GeneralFrame(Iterable<Color> colors) {
        this.setTitle("Game Lolo GA");
        this.setSize(600, 600);
        this.setLayout(
            new BorderLayout(0, 0)
        );
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.add(
            new Board(new TilesPool(6, 6), colors)
        );
        this.setVisible(true);
    }

}
