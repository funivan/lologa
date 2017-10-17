package org.funivan.lologa.algo.ga.genome

import java.util.*

class ScoreCalculation(private val genome: HashMap<String, Double>) {

    fun calculate(metric: HashMap<String, Double>): Double? {
        var score: Double? = 0.0
        val data = this.genome
        for (type in data.keys) {
            if (metric.containsKey(type)) {
                score = score!! + metric[type] * data[type]
            }
        }
        return score
    }
}
