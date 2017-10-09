package org.funivan.lologa.tile.TilesPool;

import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

public interface TilesPoolInterface {

    int cols();

    int rows();

    TilesInterface tiles();

    TilesPoolInterface withTiles(TilesInterface tiles);

}
