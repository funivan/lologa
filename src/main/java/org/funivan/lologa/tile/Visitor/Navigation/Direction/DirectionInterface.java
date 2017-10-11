package org.funivan.lologa.tile.Visitor.Navigation.Direction;

import org.funivan.lologa.tile.Position.PositionInterface;

public interface DirectionInterface {
    enum DIRECTIONS {
        Top, Right, Bottom, Left
    }

    PositionInterface position();
}
