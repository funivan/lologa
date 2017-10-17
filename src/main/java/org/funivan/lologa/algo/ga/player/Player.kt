package org.funivan.lologa.algo.ga.player

import org.funivan.lologa.algo.ga.genome.GenomeInterface
import org.funivan.lologa.algo.ga.player.round.Round
import org.funivan.lologa.board.BoardInterface

class Player(private val genome: GenomeInterface, private val board: BoardInterface) : PlayerInterface {

    private var score: Int? = null

    init {
        this.score = null
    }

    override fun genome(): GenomeInterface {
        return this.genome
    }

    override fun score(): Int {
        if (this.score == null) {
            this.score = 0
            this.score = Round().play(this.genome(), this.board)
        }
        return this.score!!
    }

    override fun compareTo(result: PlayerInterface): Int {
        return Integer.compare(result.score(), this.score())
    }

    override fun toString(): String {
        return "Score{" + this.score() + '}'
    }

}
