package org.funivan.lologa.algo.ga.genome.play

import org.funivan.lologa.algo.ga.genome.GenomeInterface
import org.funivan.lologa.algo.ga.player.PlayerInterface

interface PlayGenerationInterface {
    fun play(genomes: Iterable<GenomeInterface>): Iterable<PlayerInterface>
}
