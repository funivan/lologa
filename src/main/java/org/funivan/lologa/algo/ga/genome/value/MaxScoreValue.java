package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.tile.Score.MaxScore;
import org.funivan.lologa.tiles.TilesInterface;

public class MaxScoreValue implements ValueInterface {
    @Override
    public String type() {
        return "max_score";
    }

    @Override
    public Double value(TilesInterface tiles) {
        return (double) new MaxScore(tiles).value();
    }
}
