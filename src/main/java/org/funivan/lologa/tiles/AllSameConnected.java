package org.funivan.lologa.tiles;

import org.cactoos.iterable.IterableOf;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllSameConnected implements TilesListInterface {

    private TileInterface start;
    private TilesListInterface tiles;

    public AllSameConnected(TileInterface start, TilesListInterface tiles) {
        this.start = start;
        this.tiles = tiles;
    }


    @Override
    public Iterator<TileInterface> iterator() {
        TilesListInterface result = new TilesList(new IterableOf<>(this.start));
        List<PositionInterface> done = new ArrayList<>();
        boolean touched;
        do {
            touched = false;
            for (TileInterface check : result) {
                if (!done.contains(check.position())) {
                    touched = true;
                    done.add(check.position());
                    TilesListInterface same = new SameConnected(check, this.tiles);
                    for (TileInterface found : same) {
                        result = new JoinedTilesList(result, found);
                    }
                }
            }
        } while (touched);
        return result.iterator();
    }
}
