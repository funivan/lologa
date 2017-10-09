package org.funivan.lologa.tile.TilesPool;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;

import java.util.HashMap;

public class TilesPool implements TilesPoolInterface {
    private final int cols;
    private final int rows;
    private final TilesInterface tiles;

    public TilesPool(int width, int rows) {
        this(width, rows, new Tiles());
    }

    public TilesPool(int cols, int rows, TilesInterface tiles) {
        this.cols = cols;
        this.rows = rows;
        this.tiles = tiles;
    }

    @Override
    public int cols() {
        return this.cols;
    }

    @Override
    public int rows() {
        return this.rows;
    }


    @Override
    public TilesInterface tiles() {
        return this.tiles;
    }

    @Override
    public TilesPoolInterface withTiles(TilesInterface tiles) {
        return new TilesPool(this.cols(), this.rows(), tiles);
    }
}
