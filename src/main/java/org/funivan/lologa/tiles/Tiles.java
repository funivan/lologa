package org.funivan.lologa.tiles;

import com.sun.istack.internal.NotNull;
import org.cactoos.iterable.Filtered;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.Joined;
import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Filter.WithoutIndexFilter;


public class Tiles implements TilesInterface {
    private Iterable<TileInterface> items;

    public Tiles(Iterable<TileInterface> items) {
        this.items = items;
    }

    public Tiles() {
        this(new ListOf<>());
    }


    @Override
    public TileInterface find(PositionInterface position) {
        TileInterface result = Tile.DUMMY;
        for (TileInterface tile : this.items) {
            if (tile.position().same(position)) {
                result = tile;
                break;
            }
        }
        return result;
    }

    @Override
    public TilesInterface set(TileInterface tile) {
        return new Tiles(
            new Joined<>(
                new Filtered<>(this.items, new WithoutIndexFilter(tile.index())),
                new IterableOf<>(tile)
            )
        );
    }


    @Override
    public Iterable<TileInterface> all() {
        return this.items;
    }
}
