package org.funivan.lologa.tiles;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;

import java.util.Iterator;


public class Tiles implements TilesInterface {
    private final Iterable<TileInterface> items;

    public Tiles(Iterable<TileInterface> items) {
        this.items = items;
    }

    public Tiles() {
        this(new ListOf<>());
    }

    public Tiles(TileInterface... tiles) {
        this(new ListOf<>(tiles));
    }

    @Override
    public Iterator<TileInterface> iterator() {
        return this.items.iterator();
    }
}
