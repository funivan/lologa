package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Next;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Left;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Right;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Top;
import org.funivan.lologa.tiles.Filter.ColorFilter;

public class SameConnected extends Tiles {
    public SameConnected(TileInterface start, TilesInterface tiles) {
        super(
            new ColorFilter(start.color()),
            new Tiles(
                new Next(new Top(start), tiles),
                new Next(new Right(start), tiles),
                new Next(new Bottom(start), tiles),
                new Next(new Left(start), tiles)
            )
        );
    }
}
