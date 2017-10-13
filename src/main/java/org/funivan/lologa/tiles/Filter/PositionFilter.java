package org.funivan.lologa.tiles.Filter;

import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

public class PositionFilter implements TileFilterInterface {

    private final PositionInterface position;
    private final TileFilterInterface.EXPECT expect;

    public PositionFilter(PositionInterface positions, EXPECT expect) {
        this.position = positions;
        this.expect = expect;
    }

    public PositionFilter(PositionInterface positions) {
        this(positions, EXPECT.Positive);
    }


    @Override
    final public Boolean apply(TileInterface target) throws Exception {
        final boolean expectResult = this.expect == EXPECT.Positive;
        final boolean result = this.position.equals(target.position());
        return expectResult == result;
    }
}
