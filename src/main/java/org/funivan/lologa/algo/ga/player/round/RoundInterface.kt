package org.funivan.lologa.algo.ga.player.round

import org.funivan.lologa.algo.ga.genome.GenomeInterface
import org.funivan.lologa.board.BoardInterface

interface RoundInterface {
    fun play(genome: GenomeInterface, board: BoardInterface): Int
}
