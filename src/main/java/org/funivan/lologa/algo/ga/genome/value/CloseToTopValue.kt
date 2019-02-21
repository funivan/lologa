package org.funivan.lologa.algo.ga.genome.value

import org.funivan.lologa.tiles.TilesInterface

class CloseToTopValue : ScoreInterface {

    override fun type() = "to_top"

    override fun value(original: TilesInterface, tiles: TilesInterface): Double {
        var points = 0.0
        for (tile in original.all()) {
            val position = tile.position()
            if (!tiles.has(position)) {
                points = points + (position.row() * position.row())
            }
        }
        return points
    }

}