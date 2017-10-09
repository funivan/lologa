package org.funivan.lologa.tile;

import java.awt.*;

public class Tile implements TileInterface {

    private final Color color;
    private final int index;
    private int score;

    public Tile(Color color, int index, int score) {
        this.color = color;
        this.index = index;
        this.score = score;
    }

    public Color color() {
        return this.color;
    }

    @Override
    public int score() {
        return this.score;
    }

    @Override
    public int index() {
        return this.index;
    }
}
