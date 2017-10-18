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
import org.funivan.lologa.board.boards.Middle5To5Board
import java.util.*

object Cli {

    @JvmStatic
    fun main(args: Array<String>) {
        val gameplay = ClassicGamePlay()
        val board = Middle5To5Board(gameplay)
        val metrics = Metrics(ListOf(
                AverageScoreValue(),
                MaxScoreValue(),
                LockedTilesValue(gameplay),
                PossibleMovesValue(gameplay),
                RemovedTilesValue()
        ))
        val zeroGenome = Genome(
                object : HashMap<String, Double>() {
                    init {
                        this.put(AverageScoreValue().type(), 0.0)
                        this.put(MaxScoreValue().type(), 0.0)
                        this.put(LockedTilesValue(gameplay).type(), 0.0)
                        this.put(PossibleMovesValue(gameplay).type(), 0.0)
                        this.put(RemovedTilesValue().type(), 0.0)
                    }
                },
                gameplay,
                metrics
        )

        val playersNum = 100
        val maxGenerations = 500
        val initialPopulation = Population(Initialization(), playersNum, RandomCross())
        val nextPopulation = Population(Randomize(0.08, 0.1), playersNum, RandomCross())

        val play = LoggablePlayGeneration(0.10, PlayGeneration(board))
        var genomes = initialPopulation.populate(Repeated<GenomeInterface>(zeroGenome, playersNum))
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
