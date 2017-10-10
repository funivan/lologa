package org.funivan.lologa.tiles.Filter;

import org.cactoos.Func;
import org.cactoos.list.ListOf;
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
        this(positions, EXPECT.Same);
    }


    @Override
    final public Boolean apply(TileInterface target) throws Exception {
        final boolean expectResult = this.expect == EXPECT.Same;
        final boolean result = this.position.same(target.position());
        return expectResult == result;
    }
}
