package org.funivan.lologa.algo.find.multiple;

import org.funivan.lologa.algo.find.HandlerInterface;
import org.funivan.lologa.algo.find.one.MaxBottom;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;

public class PossibleMoves implements HandlerInterface {
    private int num;

    public PossibleMoves(int num) {
        this.num = num;
    }

    @Override
    public TilesInterface handle(TilesInterface tiles) {
        TilesInterface result = new Tiles();
        for (TileInterface tile : tiles.all()) {
            final TileInterface bottom = new MaxBottom(tile).find(tiles);
            if (!result.has(bottom.position())) {
                final int connected = new AllConnectedFinder(bottom).handle(tiles).size();
                if (connected >= this.num) {
                    result = result.with(bottom);
                }
            }
        }
        return result;
    }
}
