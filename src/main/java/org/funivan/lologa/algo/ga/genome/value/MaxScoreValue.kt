package org.funivan.lologa.algo.ga.genome.value

import org.funivan.lologa.tile.Score.MaxScore
import org.funivan.lologa.tiles.TilesInterface

class MaxScoreValue : ValueInterface {
    override fun type(): String {
        return "max_score"
    }

    override fun value(original: TilesInterface, tiles: TilesInterface): Double {
        return 1.toDouble() - MaxScore(original).value().toDouble() / MaxScore(tiles).value().toDouble()
    }
}
