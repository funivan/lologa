package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

public interface TilesInterface {

    TileInterface get(PositionInterface position);

    boolean has(PositionInterface position);

    TilesInterface without(PositionInterface position);

    TilesInterface with(TileInterface tile);

    Iterable<TileInterface> all();


}
