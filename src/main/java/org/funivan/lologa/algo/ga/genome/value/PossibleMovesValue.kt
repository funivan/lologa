package org.funivan.lologa.algo.ga.genome.value

import org.funivan.lologa.algo.find.multiple.PossibleMoves
import org.funivan.lologa.algo.gameplay.GameplayInterface
import org.funivan.lologa.tiles.TilesInterface

class PossibleMovesValue(gameplay: GameplayInterface) : ScoreInterface {

    private val possibleMoves: PossibleMoves

    init {
        this.possibleMoves = PossibleMoves(gameplay.minimum())
    }

    override fun type(): String {
        return "possible_moves"
    }

    override fun value(original: TilesInterface, tiles: TilesInterface): Double {
        return this.possibleMoves.perform(tiles).size().toDouble()
    }
}
