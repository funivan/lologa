package org.funivan.lologa.algo.ga.genome.metric

import org.funivan.lologa.algo.ga.genome.value.ScoreInterface
import org.funivan.lologa.tiles.TilesInterface
import java.util.*

class Metrics(
        private val values: Iterable<ScoreInterface>
) : MetricsInterface {

    override fun collect(original: TilesInterface, tiles: TilesInterface): HashMap<String, Double> {
        val result = HashMap<String, Double>()
        for (value in this.values) {
            result.put(value.type(), value.value(original, tiles))
        }
        return result
    }
}
