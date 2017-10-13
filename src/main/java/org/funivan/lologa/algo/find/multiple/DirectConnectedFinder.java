package org.funivan.lologa.algo.find.multiple;

import com.sun.istack.internal.NotNull;
import org.cactoos.list.ListOf;
import org.funivan.lologa.algo.find.TilesPerformer;
import org.funivan.lologa.tile.Position.Next;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;

public class DirectConnectedFinder implements TilesPerformer {

    private final TileInterface start;

    public DirectConnectedFinder(TileInterface start) {
        this.start = start;
    }

    @Override
    @NotNull
    public TilesInterface perform(TilesInterface tiles) {
        final ListOf<Next> positions = new ListOf<>(
            new Next.Top(this.start),
            new Next.Right(this.start),
            new Next.Bottom(this.start),
            new Next.Left(this.start)
        );
        TilesInterface result = new Tiles();
        for (Next position : positions) {
            if (tiles.has(position)) {
                TileInterface next = tiles.get(position);
                if (next.color().equals(this.start.color())) {
                    result = result.with(next);
                }
            }
        }
        return result;
    }
}
