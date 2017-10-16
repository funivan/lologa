package org.funivan.lologa.algo.ga.genome;

import org.funivan.lologa.algo.ga.genome.metric.MetricsInterface;
import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.util.HashMap;

public class Genome implements GenomeInterface {

    private final HashMap<String, Double> data;
    private final GameplayInterface gameplay;
    private final MetricsInterface metrics;
    private final ScoreCalculation scoreCalculator;

    public Genome(final HashMap<String, Double> data, final GameplayInterface gameplay, final MetricsInterface metrics) {
        this.data = data;
        this.gameplay = gameplay;
        this.metrics = metrics;
        this.scoreCalculator = new ScoreCalculation(this.data);
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
    public HashMap<String, Double> data() {
        return this.data;
    }


    @Override
    public GenomeInterface withData(HashMap<String, Double> data) {
        return new Genome(data, this.gameplay, this.metrics);
    }

}
