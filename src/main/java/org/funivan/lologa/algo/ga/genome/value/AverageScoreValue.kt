package org.funivan.lologa.algo.ga.genome.value

import org.funivan.lologa.tile.Score.ScoreSum
import org.funivan.lologa.tiles.TilesInterface

class AverageScoreValue : ValueInterface {
    override fun type(): String {
        return "average_score"
    }

    override fun value(original: TilesInterface, tiles: TilesInterface): Double? {
        val oldAverage = ScoreSum(original).value() / original.size().toDouble()
        val newAverage = ScoreSum(tiles).value() / tiles.size().toDouble()
        return newAverage - oldAverage
    }
}
