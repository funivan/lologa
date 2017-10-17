package org.funivan.lologa.algo.ga.genome.population

import org.cactoos.iterable.Cycled
import org.cactoos.iterable.Limited
import org.cactoos.iterable.Skipped
import org.funivan.lologa.algo.ga.genome.GenomeInterface
import org.funivan.lologa.algo.ga.genome.population.crossing.CrossingInterface
import org.funivan.lologa.algo.ga.genome.population.mutation.RandomizeInterface
import java.util.*

class Population(private val randomize: RandomizeInterface, private val size: Int, private val crossing: CrossingInterface) : PopulationInterface {


    override fun populate(genomes: Iterable<GenomeInterface>): Iterable<GenomeInterface> {
        val fathers = Cycled(Limited(genomes, this.size / 4)).iterator()
        val mothers = Cycled(Skipped(genomes, this.size / 4)).iterator()
        val result = ArrayList<GenomeInterface>()
        while (result.size < this.size) {
            val father = fathers.next()
            result.add(
                    father.withData(
                            this.randomize.mix(
                                    this.crossing.cross(father, mothers.next())
                            )
                    )
            )
        }
        return result
    }

}
