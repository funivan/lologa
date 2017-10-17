package org.funivan.lologa.algo.ga.genome.play

import org.cactoos.iterable.LengthOf
import org.cactoos.iterable.Limited
import org.cactoos.iterable.Sorted
import org.funivan.lologa.algo.ga.genome.GenomeInterface
import org.funivan.lologa.algo.ga.player.PlayerInterface

class LoggablePlayGeneration(private val slice: Double, private val origin: PlayGenerationInterface) : PlayGenerationInterface {
    private var index = 0

    override fun play(genomes: Iterable<GenomeInterface>): Iterable<PlayerInterface> {
        val generation = this.origin.play(genomes)
        println("Generation " + this.index + " Top " + (this.slice * 100).toInt() + "% results")
        this.index++
        val players = Sorted(
                Limited(generation, (LengthOf(generation).value()!! * this.slice).toInt())
        )
        for (generationPlayer in players) {
            println(generationPlayer.toString() + " P " + generationPlayer.genome().data())
        }
        return generation
    }

}
