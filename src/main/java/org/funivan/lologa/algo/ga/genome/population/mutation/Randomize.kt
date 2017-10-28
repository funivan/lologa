package org.funivan.lologa.algo.ga.genome.population.mutation

import java.util.*

class Randomize(private val rate: Double, private val step: Double) : RandomizeInterface {

    private val random: Random = Random()

    override fun mix(values: HashMap<String, Double>): HashMap<String, Double> {
        val result = HashMap<String, Double>()
        for ((type, value) in values) {
            var newValue = value
            if (this.random.nextDouble() < this.rate) {
                newValue = newValue + this.random.nextDouble() * this.step * 2.0 - this.step
            }
            result.put(type, newValue)
        }
        return result
    }
}
