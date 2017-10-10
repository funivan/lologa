package org.funivan.lologa.tile.Visitor.Collect;

import org.cactoos.iterable.IterableOf;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;

import java.util.ArrayList;
import java.util.List;

public class AllSameConnected implements CollectInterface {

    @Override
    public TilesInterface collect(TileInterface start, TilesInterface tiles) {
        TilesInterface result = new Tiles(new IterableOf<>(start));
        List<PositionInterface> done = new ArrayList<>();
        boolean touched;
        do {
            touched = false;
            for (TileInterface check : result.all()) {
                if (!done.contains(check.position())) {
                    touched = true;
                    done.add(check.position());
                    TilesInterface same = new SameConnected().collect(check, tiles);
                    for (TileInterface found : same.all()) {
                        result = new Tiles(result, found);
                    }
                }
            }
        } while (touched);
        return result;
    }


}
