package org.funivan.lologa.tiles;

import com.sun.istack.internal.NotNull;
import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

public interface TilesInterface {

    TileInterface find(PositionInterface position);

    TilesInterface set(TileInterface tile);

    Iterable<TileInterface> all();
}
