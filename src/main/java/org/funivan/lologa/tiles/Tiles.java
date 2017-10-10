package org.funivan.lologa.tiles;

import org.cactoos.iterable.Filtered;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.Joined;
import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Filter.WithoutPositionFilter;


public class Tiles implements TilesInterface {
    private Iterable<TileInterface> items;

    public Tiles(Iterable<TileInterface> items) {
        this.items = items;
    }

    public Tiles(TilesInterface tiles, TileInterface additional) {
        this(
            new Joined<>(
                new Filtered<>(tiles.all(), new WithoutPositionFilter(additional.position())),
                new IterableOf<>(additional)
            )
        );
    }


    public Tiles() {
        this(new ListOf<>());
    }


    @Override
    public Iterable<TileInterface> all() {
        return this.items;
    }
}
