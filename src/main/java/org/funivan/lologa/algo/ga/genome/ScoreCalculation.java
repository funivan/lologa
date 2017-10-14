package org.funivan.lologa.algo.ga.genome;

import java.util.HashMap;

public class ScoreCalculation {

    private final GenomeInterface genome;

    public ScoreCalculation(GenomeInterface genome) {
        this.genome = genome;
    }

    public Double calculate(final HashMap<String, Double> metric) {
        Double score = 0.0;
        for (final String metricId : this.genome.data().keySet()) {
            if (metric.containsKey(metricId)) {
                score = score + metric.get(metricId) * this.genome.data().get(metricId);
            }
        }
        return score;
    }
}
