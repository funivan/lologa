package org.funivan.lologa.algo.multiple;

import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

public interface MultipleFinder {
    Iterable<TileInterface> find(TilesInterface tiles);
}
