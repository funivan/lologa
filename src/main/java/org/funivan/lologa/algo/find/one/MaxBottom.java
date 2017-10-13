package org.funivan.lologa.algo.find.one;

import com.sun.istack.internal.NotNull;
import org.funivan.lologa.tile.Position.Next;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

public class MaxBottom implements TileFinder {
    private final TileInterface start;

    public MaxBottom(TileInterface start) {
        this.start = start;
    }

    @Override
    @NotNull
    public TileInterface find(TilesInterface tiles) {
        PositionInterface position = this.start.position();
        while (true) {
            PositionInterface next = new Next.Bottom(position);
            if (tiles.has(next) && tiles.get(next).color().equals(this.start.color())) {
                position = next;
            } else {
                break;
            }
        }
        return tiles.get(position);
    }
}
