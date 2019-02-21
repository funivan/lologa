package org.funivan.lologa.algo.ga.genome.value

import org.funivan.lologa.tiles.TilesInterface

class RemovedTilesValue : ScoreInterface {
    override fun type(): String {
        return "removed_tiles"
    }

    override fun value(original: TilesInterface, tiles: TilesInterface): Double {
        return 1 - tiles.size().toDouble() / original.size().toDouble()
    }
}
