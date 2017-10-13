package org.funivan.lologa.tiles;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;

import java.util.Iterator;


public class TilesList implements TilesListInterface {
    private final Iterable<TileInterface> items;

    public TilesList(Iterable<TileInterface> items) {
        this.items = items;
    }

    public TilesList() {
        this(new ListOf<>());
    }

    public TilesList(TileInterface... tiles) {
        this(new ListOf<>(tiles));
    }

    @Override
    public Iterator<TileInterface> iterator() {
        return this.items.iterator();
    }
}
