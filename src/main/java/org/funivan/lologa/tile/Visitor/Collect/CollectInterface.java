package org.funivan.lologa.tile.Visitor.Collect;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.TilesPool.TilesPoolInterface;
import org.funivan.lologa.tiles.TilesInterface;

public interface CollectInterface {
    TilesInterface collect(TileInterface start, TilesPoolInterface pool);
}
