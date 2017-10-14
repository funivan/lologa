package org.funivan.lologa.algo.find.multiple;

import org.funivan.lologa.algo.find.HandlerInterface;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;

/**
 * Find tiles that could not be connected
 */
public class LockedTilesFinder implements HandlerInterface {
    final private int minGroupLimit;

    public LockedTilesFinder(int minGroupLimit) {
        this.minGroupLimit = minGroupLimit;
    }

    @Override
    public TilesInterface handle(TilesInterface tiles) {
        TilesInterface result = new Tiles();
        TilesInterface done = new Tiles();
        for (TileInterface tile : tiles.all()) {
            if (!done.has(tile.position())) {
                final TilesInterface same = new AllConnectedFinder(tile).handle(tiles);
                for (TileInterface alone : same.all()) {
                    done = done.with(alone);
                }
                if (same.size() < this.minGroupLimit) {
                    for (TileInterface alone : same.all()) {
                        result = result.with(alone);
                    }
                }
            }
        }
        return result;
    }
}
