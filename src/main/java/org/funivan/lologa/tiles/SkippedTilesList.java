package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Position.TilePositions;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Filter.PositionExcluded;

import java.util.Iterator;

public class SkippedTilesList implements TilesListInterface {
    private final Iterable<TileInterface> items;

    public SkippedTilesList(Iterable<TileInterface> tiles, Iterable<TileInterface> skipped) {
        this.items = new FilteredTilesList(tiles, new PositionExcluded(new TilePositions(skipped)));
    }

    @Override
    public Iterator<TileInterface> iterator() {
        return this.items.iterator();
    }
}
