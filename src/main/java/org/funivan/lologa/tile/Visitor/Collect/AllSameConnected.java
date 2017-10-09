package org.funivan.lologa.tile.Visitor.Collect;

import org.cactoos.Func;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterator.Filtered;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.TilesPool.TilesPoolInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Left;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Right;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Top;
import org.funivan.lologa.tiles.Filter.ColorFilter;
import org.funivan.lologa.tiles.Filter.IndexFilter;
import org.funivan.lologa.tiles.FilteredTiles;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;

import java.util.ArrayList;
import java.util.List;

public class AllSameConnected implements CollectInterface {

    @Override
    public TilesInterface collect(TileInterface start, TilesPoolInterface pool) {
        TilesInterface result = new Tiles(new IterableOf<>(start));
        List<Integer> done = new ArrayList<>();
        boolean touched;
        do {
            touched = false;
            for (TileInterface check : result.all()) {
                if (!done.contains(check.index())) {
                    touched = true;
                    done.add(check.index());
                    TilesInterface same = new SameConnected().collect(check, pool);
                    for (TileInterface found : same.all()) {
                        result.set(found);
                    }
                }
            }
        } while (touched);
        return result;
    }


}
