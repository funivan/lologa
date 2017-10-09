package org.funivan.lologa.tile.Visitor.Navigation.Direction;

import org.funivan.lologa.tile.TilesPool.TilesPoolInterface;

public class Bottom implements DirectionInterface {

    @Override
    public int index(int current, TilesPoolInterface titles) {
        return current + titles.cols();
    }
}
