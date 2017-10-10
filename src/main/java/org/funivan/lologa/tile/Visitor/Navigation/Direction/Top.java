package org.funivan.lologa.tile.Visitor.Navigation.Direction;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

public class Top implements DirectionInterface {
    private final PositionInterface current;


    public Top(PositionInterface position) {
        this.current = position;
    }

    public Top(TileInterface tile) {
        this(tile.position());
    }

    @Override
    public PositionInterface position() {
        return new Position(this.current.row() - 1, this.current.col());
    }
}
