package org.funivan.lologa.algo.ga.genome.metric

import org.funivan.lologa.tiles.TilesInterface
import java.util.*

interface MetricsInterface {

    fun collect(original: TilesInterface, tiles: TilesInterface): HashMap<String, Double>

}
