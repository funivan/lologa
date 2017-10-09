package org.funivan.lologa.tile.Visitor.Collect;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.TilesPool.TilesPoolInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Left;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Right;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Top;
import org.funivan.lologa.tiles.Filter.ColorFilter;
import org.funivan.lologa.tiles.Filter.IndexFilter;
import org.funivan.lologa.tiles.FilteredTiles;
import org.funivan.lologa.tiles.TilesInterface;

public class SameConnected implements CollectInterface {
    @Override
    public TilesInterface collect(TileInterface start, TilesPoolInterface pool) {
        return new FilteredTiles(
            new ColorFilter(start.color()),
            new FilteredTiles(
                new IndexFilter(
                    new ListOf<>(
                        new Top().index(start.index(), pool),
                        new Right().index(start.index(), pool),
                        new Bottom().index(start.index(), pool),
                        new Left().index(start.index(), pool)
                    )
                ),
                pool.tiles()
            )
        );
    }
}
