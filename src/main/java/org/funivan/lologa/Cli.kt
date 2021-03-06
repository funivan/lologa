package org.funivan.lologa

import org.cactoos.iterable.Repeated
import org.cactoos.iterable.Sorted
import org.cactoos.list.ListOf
import org.funivan.lologa.algo.ga.genome.Genome
import org.funivan.lologa.algo.ga.genome.GenomeInterface
import org.funivan.lologa.algo.ga.genome.Genomes
import org.funivan.lologa.algo.ga.genome.metric.Metrics
import org.funivan.lologa.algo.ga.genome.play.LoggablePlayGeneration
import org.funivan.lologa.algo.ga.genome.play.PlayGeneration
import org.funivan.lologa.algo.ga.genome.population.Population
import org.funivan.lologa.algo.ga.genome.population.crossing.RandomCross
import org.funivan.lologa.algo.ga.genome.population.mutation.Initialization
import org.funivan.lologa.algo.ga.genome.population.mutation.Randomize
import org.funivan.lologa.algo.ga.genome.value.*
import org.funivan.lologa.algo.gameplay.ClassicGamePlay
import org.funivan.lologa.board.boards.Complicated8To8Board

object Cli {

    @JvmStatic
    fun main(args: Array<String>) {
        val gameplay = ClassicGamePlay()
        val board = Complicated8To8Board(gameplay)
        val metrics = Metrics(ListOf(
                AverageScore(),
                MaxScoreValue(),
                LockedTiles(gameplay),
                PossibleMovesValue(gameplay),
                RemovedTilesValue()
        ))
        val zeroGenome = Genome(
                hashMapOf(
                        AverageScore().type() to 0.0,
                        MaxScoreValue().type() to 0.0,
                        LockedTiles(gameplay).type() to 0.0,
                        PossibleMovesValue(gameplay).type() to 0.0,
                        RemovedTilesValue().type() to 0.0
                ),
                gameplay,
                metrics
        )

        val playersNum = 50
        val maxGenerations = 500
        val initialPopulation = Population(Initialization(), playersNum, RandomCross())
        val nextPopulation = Population(Randomize(0.05, 0.3), playersNum, RandomCross())

        val play = LoggablePlayGeneration(0.10, PlayGeneration(board))
        var genomes = initialPopulation.populate(Repeated<GenomeInterface>(playersNum, zeroGenome))
        for (g in 1 until maxGenerations) {
            val generation = play.play(genomes)
            genomes = nextPopulation.populate(
                    Genomes(
                            Sorted(generation)
                    )
            )
        }

    }
}
