package org.funivan.lologa;

import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesList;

import javax.swing.*;
import java.awt.*;

public class GeneralFrame extends JFrame {
    public GeneralFrame(Iterable<Color> colors) {
        this.setTitle("Game Lolo GA");
        this.setSize(600, 600);
        this.setLayout(
            new BorderLayout(0, 0)
        );
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.add(
            new Board(new Tiles(), 3, 3, colors)
        );
        this.setVisible(true);
    }

}
