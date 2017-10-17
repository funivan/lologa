package org.funivan.lologa.algo.ga.genome.population.mutation

import java.util.*

class Randomize(private val rate: Double, private val step: Double) : RandomizeInterface {
    private val random: Random

    init {
        this.random = Random()
    }


    override fun mix(values: HashMap<String, Double>): HashMap<String, Double> {


        val result = HashMap<String, Double>()
        for (type in values.keys) {
            var value: Double? = values[type]
            if (this.random.nextDouble() < this.rate) {
                value = value!! + this.random.nextDouble() * this.step * 2.0 - this.step
            }

            result.put(type, value)
        }
        return result
    }
}
