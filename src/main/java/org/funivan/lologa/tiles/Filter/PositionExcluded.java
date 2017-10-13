package org.funivan.lologa.tiles.Filter;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

public class PositionExcluded implements TileFilterInterface {
    private Iterable<PositionInterface> positions;

    public PositionExcluded(Iterable<PositionInterface> positions) {
        this.positions = positions;
    }

    public PositionExcluded(PositionInterface position) {
        this(new ListOf<>(position));
    }


    @Override
    public Boolean apply(TileInterface target) throws Exception {
        boolean result = true;
        final PositionInterface targetPosition = target.position();
        for (PositionInterface position : this.positions) {
            if (position.equals(targetPosition)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
