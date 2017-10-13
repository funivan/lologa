package org.funivan.lologa.tiles;

import org.cactoos.Func;
import org.funivan.lologa.tile.TileInterface;

import java.util.Iterator;

public class FilteredTilesList implements TilesListInterface {
    private final org.cactoos.iterable.Filtered<TileInterface> items;

    public FilteredTilesList(Iterable<TileInterface> tiles, Func<TileInterface, Boolean> filter) {
        this.items = new org.cactoos.iterable.Filtered<>(tiles, filter);
    }


    @Override
    public Iterator<TileInterface> iterator() {
        return this.items.iterator();
    }
}
