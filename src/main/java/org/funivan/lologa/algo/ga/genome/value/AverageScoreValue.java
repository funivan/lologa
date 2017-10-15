package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.tile.Score.ScoreSum;
import org.funivan.lologa.tiles.TilesInterface;

public class AverageScoreValue implements ValueInterface {
    @Override
    public String type() {
        return "average_score";
    }

    @Override
    public Double value(TilesInterface original, TilesInterface tiles) {
        double oldAverage = new ScoreSum(original).value() / (double) original.size();
        double newAverage = new ScoreSum(tiles).value() / (double) tiles.size();
        return newAverage - oldAverage;
    }
}
