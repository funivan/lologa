package org.funivan.lologa.algo.gameplay;

import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

public interface GameplayInterface {
    int minimum();

    TilesInterface interact(TileInterface tile, TilesInterface tiles);
}
