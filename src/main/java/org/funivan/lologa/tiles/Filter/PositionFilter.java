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
    public Boolean apply(TileInterface tileInterface) throws Exception {
        return this.positions.contains(
            tileInterface.position()
        );
    }
}
