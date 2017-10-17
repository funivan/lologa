package org.funivan.lologa.algo.ga.genome.population.mutation

import java.util.*

interface RandomizeInterface {
    fun mix(values: HashMap<String, Double>): HashMap<String, Double>
}
