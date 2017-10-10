package org.funivan.lologa.tile.Visitor.Navigation.Direction;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;

public class Left implements DirectionInterface {

    @Override
    public PositionInterface next(PositionInterface current) {
        return new Position(current.row(), current.col() - 1);
    }
}
