package org.funivan.lologa.tiles.Filter;

import org.cactoos.Func;
import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

public class WithoutPositionFilter implements Func<TileInterface, Boolean> {

    private ListOf<PositionInterface> positions;


    public WithoutPositionFilter(PositionInterface position) {
        this.positions = new ListOf<>(position);
    }

    @Override
    public Boolean apply(TileInterface tileInterface) {
        return !this.positions.contains(
            tileInterface.position()
        );
    }

}
