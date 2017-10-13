package org.funivan.lologa.algo.multiple;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.Position.Next;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.util.ArrayList;

public class DirectConnectedFinder implements MultipleFinder {

    private final TileInterface start;

    public DirectConnectedFinder(TileInterface start) {
        this.start = start;
    }

    @Override
    public Iterable<TileInterface> find(TilesInterface tiles) {
        final ListOf<Next> positions = new ListOf<>(
            new Next.Top(this.start),
            new Next.Right(this.start),
            new Next.Bottom(this.start),
            new Next.Left(this.start)
        );
        ArrayList<TileInterface> result = new ArrayList<>();
        for (Next position : positions) {
            if (tiles.has(position)) {
                TileInterface next = tiles.get(position);
                if (next.color().equals(this.start.color())) {
                    result.add(next);
                }
            }
        }
        return result;
    }
}
