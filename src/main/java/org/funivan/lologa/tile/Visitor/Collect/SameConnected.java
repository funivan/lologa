package org.funivan.lologa.tile.Visitor.Collect;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Left;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Right;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Top;
import org.funivan.lologa.tiles.Filter.ColorFilter;
import org.funivan.lologa.tiles.Filter.PositionFilter;
import org.funivan.lologa.tiles.FilteredTiles;
import org.funivan.lologa.tiles.TilesInterface;

public class SameConnected implements CollectInterface {
    @Override
    public TilesInterface collect(TileInterface start, TilesInterface tiles) {
        return new FilteredTiles(
            new ColorFilter(start.color()),
            new FilteredTiles(
                new PositionFilter(
                    new ListOf<>(
                        new Top().next(start.position()),
                        new Right().next(start.position()),
                        new Bottom().next(start.position()),
                        new Left().next(start.position())
                    )
                ),
                tiles
            )
        );
    }
}
