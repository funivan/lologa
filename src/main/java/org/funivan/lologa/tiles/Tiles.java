package org.funivan.lologa.tiles;

import org.cactoos.Func;
import org.cactoos.iterable.Filtered;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.Joined;
import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Filter.PositionFilter;
import org.funivan.lologa.tiles.Filter.TileFilterInterface;


public class Tiles implements TilesInterface {
    private Iterable<TileInterface> items;

    public Tiles(Iterable<TileInterface> items) {
        this.items = items;
    }

    public Tiles(TilesInterface tiles, TileInterface additional) {
        this(
            new Joined<>(
                new Filtered<>(
                    tiles.all(),
                    new PositionFilter(additional.position(), TileFilterInterface.EXPECT.Different)
                ),
                new IterableOf<>(additional)
            )
        );

    }

    public Tiles(Func<TileInterface, Boolean> filter, TilesInterface tiles) {
        this(
            new Filtered<>(tiles.all(), filter)
        );
    }


    public Tiles() {
        this(new ListOf<>());
    }

    public Tiles(TileInterface... tiles) {
        this(new ListOf<>(tiles));
    }


    @Override
    final public Iterable<TileInterface> all() {
        return this.items;
    }
}
