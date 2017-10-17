package org.funivan.lologa.tile.Score

import org.funivan.lologa.tile.TileInterface
import org.funivan.lologa.tiles.TilesInterface

class ScoreSum : ScoreInterface {
    private val tiles: Iterable<TileInterface>

    constructor(tiles: Iterable<TileInterface>) {
        this.tiles = tiles
    }

    constructor(tiles: TilesInterface) {
        this.tiles = tiles.all()
    }

    override fun value(): Int {
        var score = 0
        for (tile in this.tiles) {
            score = score + tile.score().value()
        }
        return score
    }

    override fun toString(): String {
        return "Score{" + this.value() + '}'
    }
}
