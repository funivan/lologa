package org.funivan.lologa.tiles;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.Position.TilePositions;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Filter.PositionExcluded;

import java.util.Iterator;

public class JoinedTilesList implements TilesListInterface {

    private Iterable<TileInterface> items;

    public JoinedTilesList(Iterable<TileInterface> tiles, Iterable<TileInterface> additional) {
        this.items = new org.cactoos.iterable.Joined<>(
            new FilteredTilesList(
                tiles,
                new PositionExcluded(new TilePositions(additional))
            ),
            additional
        );
    }

    public JoinedTilesList(Iterable<TileInterface> tiles, TileInterface additional) {
        this(tiles, new ListOf<>(additional));
    }


    @Override
    public Iterator<TileInterface> iterator() {
        return this.items.iterator();
    }
}
