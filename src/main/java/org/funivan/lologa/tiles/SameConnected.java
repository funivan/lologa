package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Next;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Left;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Right;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Top;
import org.funivan.lologa.tiles.Filter.ColorFilter;

import java.util.Iterator;

public class SameConnected implements TilesInterface {
    private final TilesInterface iterator;

    public SameConnected(TileInterface start, TilesInterface tiles) {
        this.iterator = new FilteredTiles(
            new Tiles(
                new Next(new Top(start), tiles),
                new Next(new Right(start), tiles),
                new Next(new Bottom(start), tiles),
                new Next(new Left(start), tiles)
            ),
            new ColorFilter(start.color())
        );
    }

    @Override
    public Iterator<TileInterface> iterator() {
        return this.iterator.iterator();
    }
}
