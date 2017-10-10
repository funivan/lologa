package org.funivan.lologa.tiles;

import org.cactoos.iterable.Filtered;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.Joined;
import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Filter.WithoutPositionFilter;


public class Tiles implements TilesInterface {
    private Iterable<TileInterface> items;

    public Tiles(Iterable<TileInterface> items) {
        this.items = items;
    }

    public Tiles() {
        this(new ListOf<>());
    }


    @Override
    public TilesInterface withTile(TileInterface tile) {
        return new Tiles(
            new Joined<>(
                new Filtered<>(this.items, new WithoutPositionFilter(tile.position())),
                new IterableOf<>(tile)
            )
        );
    }


    @Override
    public Iterable<TileInterface> all() {
        return this.items;
    }
}
