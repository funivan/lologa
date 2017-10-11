package org.funivan.lologa.tile.Position;

import org.cactoos.iterable.Joined;
import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class TilePositions implements PositionsInterface {
    private Iterable<TileInterface> tiles;

    public TilePositions(Iterable<TileInterface> tiles) {
        this.tiles = tiles;
    }

    @Override
    public Iterator<PositionInterface> iterator() {
        ArrayList<PositionInterface> result = new ArrayList<>();
        for (TileInterface tile : this.tiles) {
            result.add(tile.position());
        }
        return result.iterator();
    }
}
