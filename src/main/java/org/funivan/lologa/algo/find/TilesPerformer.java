package org.funivan.lologa.algo.find;

import com.sun.istack.internal.NotNull;
import org.funivan.lologa.tiles.TilesInterface;

public interface TilesPerformer {
    @NotNull
    TilesInterface perform(TilesInterface tiles);
}
