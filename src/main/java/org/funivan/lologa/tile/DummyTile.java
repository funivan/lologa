package org.funivan.lologa.tile;

import java.awt.*;

public class DummyTile implements TileInterface {
    @Override
    public Color color() {
        return new Color(-100, -100, -100);
    }

    @Override
    public int score() {
        return -100;
    }

    @Override
    public int index() {
        return -100;
    }
}
