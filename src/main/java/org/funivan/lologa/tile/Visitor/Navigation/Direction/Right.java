package org.funivan.lologa.tile.Visitor.Navigation.Direction;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

public class Right implements DirectionInterface {

    private final PositionInterface current;

    public Right(PositionInterface position) {
        this.current = position;
    }

    public Right(TileInterface tile) {
        this(tile.position());
    }


    @Override
    public PositionInterface position() {
        return new Position(this.current.row(), this.current.col() + 1);
    }
}
