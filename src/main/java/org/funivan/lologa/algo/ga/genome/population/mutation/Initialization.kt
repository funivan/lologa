package org.funivan.lologa.algo.ga.genome.population.mutation

import java.util.*

class Initialization : RandomizeInterface {
    private val random: Random

    init {
        this.random = Random()
    }


    override fun mix(values: HashMap<String, Double>): HashMap<String, Double> {
        val result = HashMap<String, Double>()
        for (type in values.keys) {
            result.put(type, this.random.nextDouble() - 0.5)
        }
        return result
    }
}
