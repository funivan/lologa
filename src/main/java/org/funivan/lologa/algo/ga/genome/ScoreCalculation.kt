package org.funivan.lologa.algo.ga.genome

import java.util.*

class ScoreCalculation(private val genome: HashMap<String, Double>) {

    fun calculate(metric: HashMap<String, Double>): Double {
        var score = 0.0
        val data = this.genome
        for ((type, modifier) in data) {
            val value : Double? = metric.get(type)
            if (value != null) {
                score = score + value * modifier
            }
        }
        return score
    }
}
