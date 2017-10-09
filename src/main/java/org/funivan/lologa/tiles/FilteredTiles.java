package org.funivan.lologa.tiles;

import org.cactoos.Func;
import org.cactoos.iterable.Filtered;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;

public class FilteredTiles implements TilesInterface {
    private final Func<TileInterface, Boolean> filter;
    private final TilesInterface origin;

    public FilteredTiles(Func<TileInterface, Boolean> filter, TilesInterface origin) {
        this.filter = filter;
        this.origin = origin;
    }

    @Override
    public TileInterface get(int index) {
        TileInterface result = Tile.DUMMY;
        for (TileInterface tile : this.all()) {
            if (tile.index() == index) {
                result = tile;
                break;
            }
        }
        return result;
    }

    @Override
    public TilesInterface set(TileInterface tile) {
        return this.origin.set(tile);
    }

    @Override
    public boolean has(int index) {
        return !this.get(index).equals(Tile.DUMMY);
    }

    @Override
    public Iterable<TileInterface> all() {
        return new Filtered<>(this.origin.all(), this.filter);
    }
}
