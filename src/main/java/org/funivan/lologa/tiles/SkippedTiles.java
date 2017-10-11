package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Position.TilePositions;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Filter.PositionExcluded;

import java.util.Iterator;

public class SkippedTiles implements TilesInterface {
    private final Iterable<TileInterface> items;

    public SkippedTiles(Iterable<TileInterface> tiles, Iterable<TileInterface> skipped) {
        this.items = new FilteredTiles(tiles, new PositionExcluded(new TilePositions(skipped)));
    }

    @Override
    public Iterator<TileInterface> iterator() {
        return this.items.iterator();
    }
}
