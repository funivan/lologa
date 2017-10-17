package org.funivan.lologa.algo.ga.genome.population

import org.funivan.lologa.algo.ga.genome.GenomeInterface

interface PopulationInterface {

    fun populate(genomes: Iterable<GenomeInterface>): Iterable<GenomeInterface>

}
