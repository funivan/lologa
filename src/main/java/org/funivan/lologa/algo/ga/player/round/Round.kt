package org.funivan.lologa.algo.ga.player.round

import org.funivan.lologa.algo.ga.genome.GenomeInterface
import org.funivan.lologa.board.BoardInterface
import org.funivan.lologa.tile.Score.ScoreSum

class Round : RoundInterface {

    override fun play(genome: GenomeInterface, board: BoardInterface): Int {
        var board = board
        var max = 0
        var moves = 50
        do {
            moves--
            board = board.interact(
                    genome.find(
                            board.tiles()
                    ).position()
            )
            val current = ScoreSum(board.tiles()).value()
            if (current > max) {
                max = current
            } else {
                moves = 0
            }
        } while (moves > 0)

        return max
    }
}
