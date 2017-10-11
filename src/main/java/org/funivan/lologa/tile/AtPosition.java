package org.funivan.lologa.tile;

import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Score.ScoreInterface;

import java.awt.*;

public class AtPosition implements TileInterface {
    private TileInterface found = null;
    private final PositionInterface position;
    private final Iterable<TileInterface> tiles;
    private final TileInterface fallback;

    public AtPosition(PositionInterface position, Iterable<TileInterface> tiles) {
        this.position = position;
        this.tiles = tiles;
        this.fallback = Tile.DUMMY;
    }

    @Override
    public Color color() {
        return this.find().color();
    }

    @Override
    public ScoreInterface score() {
        return this.find().score();
    }


    @Override
    public PositionInterface position() {
        return this.find().position();
    }

    @Override
    public boolean same(TileInterface target) {
        return this.find().same(target);
    }

    private TileInterface find() {
        if (this.found == null) {
            this.found = this.fallback;
            for (TileInterface tile : this.tiles) {
                if (tile.position().same(this.position)) {
                    this.found = tile;
                    break;
                }
            }
        }
        return this.found;
    }
}
