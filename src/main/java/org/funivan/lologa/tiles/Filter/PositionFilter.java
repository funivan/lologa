package org.funivan.lologa.tiles.Filter;

import org.cactoos.Func;
import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

public class PositionFilter implements Func<TileInterface, Boolean> {

    private final ListOf<PositionInterface> positions;

    public PositionFilter(ListOf<PositionInterface> positions) {
        this.positions = positions;
    }


    @Override
    final public Boolean apply(TileInterface target) throws Exception {
        boolean result = false;
        for (PositionInterface position : this.positions) {
            if (position.same(target.position())) {
                result = true;
                break;
            }
        }
        return result;
    }
}
