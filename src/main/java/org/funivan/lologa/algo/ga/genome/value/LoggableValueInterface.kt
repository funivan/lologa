package org.funivan.lologa.algo.ga.genome.value

import org.funivan.lologa.tiles.TilesInterface

class LoggableValueInterface(private val show: Boolean, private val origin: ScoreInterface) : ScoreInterface {

    override fun type(): String {
        return this.origin.type()
    }

    override fun value(original: TilesInterface, tiles: TilesInterface): Double {
        val result = this.origin.value(original, tiles)
        if (this.show) {
            println(this.javaClass.toString() + " = " + result)
        }
        return result
    }
}
