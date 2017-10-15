package org.funivan.lologa.algo.ga.genome;

import org.funivan.lologa.algo.ga.genome.value.ValueInterface;

import java.util.HashMap;

public class ScoreCalculation {

    private final GenomeInterface genome;

    public ScoreCalculation(GenomeInterface genome) {
        this.genome = genome;
    }

    public Double calculate(final HashMap<String, Double> metric) {
        Double score = 0.0;
        final HashMap<String, Double> data = this.genome.data();
        for (final String type : data.keySet()) {
            if (metric.containsKey(type)) {
                score = score + metric.get(type) * data.get(type);
            }
        }
        return score;
    }
}
