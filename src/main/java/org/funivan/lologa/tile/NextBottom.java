package org.funivan.lologa.tile;

import org.funivan.lologa.tile.TilesPool.TilesPoolInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.awt.*;

public class NextBottom implements TileInterface {
    private final TilesPoolInterface pool;
    private final TileInterface original;

    public NextBottom(TilesPoolInterface pool, TileInterface original) {
        this.pool = pool;
        this.original = original;
    }

    @Override
    public Color color() {
        return this.original.color();
    }

    @Override
    public int score() {
        return this.bottom().score();
    }

    @Override
    public int index() {
        return this.bottom().index();
    }

    private TileInterface bottom() {
        int next = this.original.index();
        TileInterface result = this.original;
        final TilesInterface tiles = this.pool.tiles();
        while (tiles.has(next) && tiles.get(next).color().equals(this.original.color())) {
            result = tiles.get(next);
            next = next + pool.cols();
        }
        return result;
    }
}
