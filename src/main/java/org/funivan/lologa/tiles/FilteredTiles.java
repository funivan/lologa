package org.funivan.lologa.tiles;

import org.cactoos.Func;
import org.funivan.lologa.tile.TileInterface;

import java.util.Iterator;

public class FilteredTiles implements TilesInterface {
    private final org.cactoos.iterable.Filtered<TileInterface> items;

    public FilteredTiles(Iterable<TileInterface> tiles, Func<TileInterface, Boolean> filter) {
        this.items = new org.cactoos.iterable.Filtered<>(tiles, filter);
    }


    @Override
    public Iterator<TileInterface> iterator() {
        return this.items.iterator();
    }
}
