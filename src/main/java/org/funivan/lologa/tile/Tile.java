package org.funivan.lologa.tile;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Score.Score;
import org.funivan.lologa.tile.Score.ScoreInterface;

import java.awt.*;
import java.util.Objects;

public class Tile implements TileInterface {
    public static Tile DUMMY;

    static {
        DUMMY = new Tile(new Color(255, 255, 255), new Score(-100), new Position(-100, -100));
    }

    private final Color color;
    private ScoreInterface score;
    private PositionInterface position;

    public Tile(Color color, ScoreInterface score, PositionInterface position) {
        this.color = color;
        this.score = score;
        this.position = position;
    }

    public Tile(Color color, PositionInterface position) {
        this(color, new Score(1), position);
    }

    public Color color() {
        return this.color;
    }

    @Override
    public ScoreInterface score() {
        return this.score;
    }


    @Override
    public PositionInterface position() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        } else if (o instanceof TileInterface) {
            TileInterface target = (TileInterface) o;
            result = (
                target.color().equals(this.color()) && target.position().equals(this.position())
            );
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.color, this.score, this.position);
    }

    @Override
    public boolean same(TileInterface target) {
        return (target.score().value() == this.score().value()
            &&
            target.color().equals(this.color())
            &&
            target.position().equals(this.position())
        );
    }

    @Override
    public String toString() {
        return "Tile: " +
            "{Color{r" + this.color.getRed() + ",g" + this.color.getGreen() + ",b" + this.color.getBlue() + "}}"
            + "," + this.score + ""
            + "," + this.position;
    }
}
