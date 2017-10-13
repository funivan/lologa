package org.funivan.lologa.algo.find.multiple;

import org.funivan.lologa.algo.find.TilesPerformer;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;

/**
 * Core Tile - first single tile in group
 */
public class CoreTilesInGroupFinder implements TilesPerformer {
    private int minGroupLen;

    public CoreTilesInGroupFinder(int minGroupLen) {
        this.minGroupLen = minGroupLen;
    }

    @Override
    public TilesInterface perform(TilesInterface tiles) {
        TilesInterface result = new Tiles();
        TilesInterface done = new Tiles();
        for (TileInterface tile : tiles.all()) {
            if (!done.has(tile.position())) {
                TilesInterface connectedTiles = new AllConnectedFinder(tile).perform(tiles);
                for (TileInterface connected : connectedTiles.all()) {
                    done = done.with(connected);
                }
                if (connectedTiles.size() >= this.minGroupLen) {
                    result = result.with(tile);
                }
            }
        }
        return result;
    }

}
