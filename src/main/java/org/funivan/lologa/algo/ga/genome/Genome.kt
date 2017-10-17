package org.funivan.lologa.algo.ga.genome

import org.funivan.lologa.algo.ga.genome.metric.MetricsInterface
import org.funivan.lologa.algo.gameplay.GameplayInterface
import org.funivan.lologa.tile.Tile
import org.funivan.lologa.tile.TileInterface
import org.funivan.lologa.tiles.TilesInterface
import java.util.*

class Genome(
    private val data: HashMap<String, Double>,
    private val gameplay: GameplayInterface,
    private val metrics: MetricsInterface
) : GenomeInterface {

    private val scoreCalculator: ScoreCalculation = ScoreCalculation(this.data)


    override fun find(tiles: TilesInterface): TileInterface {
        var result = Tile.DUMMY
        var max = 0.0
        for (tile in tiles.all()) {
            val newTiles = this.gameplay.interact(tile, tiles)
            val stepMetric = this.metrics.collect(tiles, newTiles)
            val score = this.scoreCalculator.calculate(stepMetric)
            if (score > max) {
                result = tile
                max = score
            }
        }
        return result
    }

    override fun data(): HashMap<String, Double> {
        return this.data
    }


    override fun withData(data: HashMap<String, Double>): GenomeInterface {
        return Genome(data, this.gameplay, this.metrics)
    }

}
