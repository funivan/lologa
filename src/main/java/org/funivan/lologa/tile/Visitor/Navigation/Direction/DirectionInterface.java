package org.funivan.lologa.tile.Visitor.Navigation.Direction;

import org.funivan.lologa.tile.TilesPool.TilesPoolInterface;

public interface DirectionInterface {
    int index(int current, TilesPoolInterface titles);
}
