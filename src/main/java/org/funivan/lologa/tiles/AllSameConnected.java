package org.funivan.lologa.tiles;

import org.cactoos.iterable.IterableOf;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllSameConnected implements TilesInterface {

    private TileInterface start;
    private TilesInterface tiles;

    public AllSameConnected(TileInterface start, TilesInterface tiles) {
        this.start = start;
        this.tiles = tiles;
    }


    @Override
    public Iterator<TileInterface> iterator() {
        TilesInterface result = new Tiles(new IterableOf<>(this.start));
        List<PositionInterface> done = new ArrayList<>();
        boolean touched;
        do {
            touched = false;
            for (TileInterface check : result) {
                if (!done.contains(check.position())) {
                    touched = true;
                    done.add(check.position());
                    TilesInterface same = new SameConnected(check, this.tiles);
                    for (TileInterface found : same) {
                        result = new JoinedTiles(result, found);
                    }
                }
            }
        } while (touched);
        return result.iterator();
    }
}
