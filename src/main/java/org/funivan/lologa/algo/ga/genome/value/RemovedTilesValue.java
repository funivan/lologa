package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.tiles.TilesInterface;

public class RemovedTilesValue implements ValueInterface {
    @Override
    public String type() {
        return "removed_tiles";
    }

    @Override
    public Double value(TilesInterface original, TilesInterface tiles) {
        return 1 - (double) tiles.size() / (double) original.size();
    }
}
