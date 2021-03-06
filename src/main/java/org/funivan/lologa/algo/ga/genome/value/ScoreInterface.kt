package org.funivan.lologa.algo.ga.genome.value

import org.funivan.lologa.tiles.TilesInterface

interface ScoreInterface {

    fun type(): String

    fun value(original: TilesInterface, tiles: TilesInterface): Double

}
