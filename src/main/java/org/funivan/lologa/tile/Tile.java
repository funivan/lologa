package org.funivan.lologa.tile;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;

import java.awt.*;

public class Tile implements TileInterface {
    public static Tile DUMMY;

    static {
        DUMMY = new Tile(new Color(255, 255, 255), -100, new Position(-100, -100));
    }

    private final Color color;
    private int score;
    private PositionInterface position;

    public Tile(Color color, int score, PositionInterface position) {
        this.color = color;
        this.score = score;
        this.position = position;
    }

    public Tile(Color color, PositionInterface position) {
        this(color, 1, position);
    }

    public Color color() {
        return this.color;
    }

    @Override
    public int score() {
        return this.score;
    }


    @Override
    public PositionInterface position() {
        return this.position;
    }

    @Override
    public boolean same(TileInterface target) {
        return (target.score() == this.score()
            &&
            target.color().equals(this.color())
            &&
            target.position().same(this.position())
        );
    }
}
