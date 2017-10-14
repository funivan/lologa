package org.funivan.lologa.algo.ga.player;

import org.funivan.lologa.algo.find.one.TileFinder;
import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.algo.ga.genome.ScoreCalculation;
import org.funivan.lologa.algo.ga.genome.metric.MetricCollector;
import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.util.HashMap;

public class Decision implements TileFinder {

    private final GenomeInterface genome;
    private final GameplayInterface gameplay;
    private final MetricCollector metricCollector;
    private ScoreCalculation scoreCalculator;

    public Decision(final GenomeInterface genome, final GameplayInterface gameplay) {
        this.genome = genome;
        this.gameplay = gameplay;
        this.metricCollector = new MetricCollector(gameplay);
        this.scoreCalculator = new ScoreCalculation(this.genome);
    }


    @Override
    public TileInterface find(TilesInterface tiles) {
        TileInterface result = Tile.DUMMY;
        Double max = 0.0;
        for (TileInterface tile : tiles.all()) {
            final HashMap<String, Double> stepMetric = this.metricCollector.collect(
                this.gameplay.interact(tile, tiles)
            );
            if (this.scoreCalculator.calculate(stepMetric) > max) {
                result = tile;
            }
        }
        return result;
    }
}
