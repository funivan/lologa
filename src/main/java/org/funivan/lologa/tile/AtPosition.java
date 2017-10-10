package org.funivan.lologa.tile;

import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.awt.*;

public class AtPosition implements TileInterface {
    private final PositionInterface position;
    private final TilesInterface tiles;
    private final Tile fallback;

    public AtPosition(PositionInterface position, TilesInterface tiles) {
        this.position = position;
        this.tiles = tiles;
        this.fallback = Tile.DUMMY;
    }

    @Override
    public Color color() {
        return this.find().color();
    }

    @Override
    public int score() {
        return this.find().score();
    }

    @Override
    public int index() {
        return this.find().index();
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
        TileInterface result = this.fallback;
        for (TileInterface tile : this.tiles.all()) {
            if (tile.position().same(this.position)) {
                result = tile;
                break;
            }
        }
        return result;
    }
}
