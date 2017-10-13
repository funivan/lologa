package org.funivan.lologa.algo.find.multiple;

import org.funivan.lologa.algo.find.HandlerInterface;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;

/**
 * Find tiles that are not connected with each other
 */
public class SingleTilesFinder implements HandlerInterface {

    @Override
    public TilesInterface handle(TilesInterface tiles) {
        TilesInterface result = new Tiles();
        for (TileInterface tile : tiles.all()) {
            final Integer len = new DirectConnectedFinder(tile).handle(tiles).size();
            if (len == 0) {
                result = result.with(tile);
            }
        }
        return result;
    }
}
