package org.funivan.lologa.algo.ga.genome.play

import org.cactoos.iterable.IterableOf
import org.cactoos.iterable.Joined
import org.funivan.lologa.algo.ga.genome.GenomeInterface
import org.funivan.lologa.algo.ga.player.Player
import org.funivan.lologa.algo.ga.player.PlayerInterface
import org.funivan.lologa.board.BoardInterface

class PlayGeneration(private val board: BoardInterface) : PlayGenerationInterface {

    override fun play(genomes: Iterable<GenomeInterface>): Iterable<PlayerInterface> {
        var generation: Iterable<PlayerInterface> = IterableOf()
        for (genome in genomes) {
            val max = Player(genome, this.board)
            generation = Joined(generation, IterableOf<PlayerInterface>(max))
        }
        return generation
    }

}
