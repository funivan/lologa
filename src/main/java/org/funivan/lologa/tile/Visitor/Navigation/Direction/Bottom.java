package org.funivan.lologa.tile.Visitor.Navigation.Direction;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

public class Bottom implements DirectionInterface {

    private final PositionInterface current;

    public Bottom(PositionInterface position) {
        this.current = position;
    }

    public Bottom(TileInterface tile) {
        this(tile.position());
    }

    @Override
    public PositionInterface position() {
        return new Position(this.current.row() + 1, this.current.col());
    }
}
