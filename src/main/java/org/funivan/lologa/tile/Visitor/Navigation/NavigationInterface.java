package org.funivan.lologa.tile.Visitor.Navigation;

import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.TilesPool.TilesPoolInterface;

public interface NavigationInterface {
    TileInterface navigate(TileInterface start, TilesPoolInterface tilesPool);
}
