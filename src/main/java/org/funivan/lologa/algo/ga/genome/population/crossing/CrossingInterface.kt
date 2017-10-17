package org.funivan.lologa.algo.ga.genome.population.crossing

import org.funivan.lologa.algo.ga.genome.GenomeInterface
import java.util.*

interface CrossingInterface {
    fun cross(father: GenomeInterface, mother: GenomeInterface): HashMap<String, Double>
}
