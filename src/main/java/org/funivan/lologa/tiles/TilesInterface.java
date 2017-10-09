package org.funivan.lologa.tiles;

import com.sun.istack.internal.NotNull;
import org.funivan.lologa.tile.TileInterface;

public interface TilesInterface {
    @NotNull
    TileInterface get(int index);

    TilesInterface set(TileInterface tile);

    boolean has(int index);

    Iterable<TileInterface> all();
}
