package org.funivan.lologa.algo.ga.player;

import org.funivan.lologa.algo.ga.fitness.Fitness;
import org.funivan.lologa.algo.ga.fitness.FitnessInterface;
import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.algo.ga.genome.ScoreCalculation;
import org.funivan.lologa.algo.ga.genome.metric.MetricsInterface;
import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.tile.Score.MaxScore;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.util.HashMap;

public class Player implements PlayerInterface {

    private final GenomeInterface genome;
    private final GameplayInterface gameplay;
    private final MetricsInterface metrics;
    private final ScoreCalculation scoreCalculator;

    public Player(final GenomeInterface genome, final GameplayInterface gameplay, final MetricsInterface metrics) {
        this.genome = genome;
        this.gameplay = gameplay;
        this.metrics = metrics;
        this.scoreCalculator = new ScoreCalculation(this.genome);
    }


    @Override
    public TileInterface find(TilesInterface tiles) {
        TileInterface result = Tile.DUMMY;
        Double max = 0.0;
        for (TileInterface tile : tiles.all()) {
            TilesInterface newTiles = this.gameplay.interact(tile, tiles);
            final HashMap<String, Double> stepMetric = this.metrics.collect(tiles, newTiles);
            Double score = this.scoreCalculator.calculate(stepMetric);
            if (score > max) {
                result = tile;
                max = score;
            }
        }
        return result;
    }

    @Override
    public FitnessInterface fitness(TilesInterface tiles) {
        return new Fitness(
            new MaxScore(tiles.all()).value()
        );
    }
}
