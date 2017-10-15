package org.funivan.lologa.algo.ga.genome;

import java.util.HashMap;

public class ScoreCalculation {

    private final  HashMap<String, Double> genome;

    public ScoreCalculation(HashMap<String, Double> genome) {
        this.genome = genome;
    }

    public Double calculate(final HashMap<String, Double> metric) {
        Double score = 0.0;
        final HashMap<String, Double> data = this.genome;
        for (final String type : data.keySet()) {
            if (metric.containsKey(type)) {
                score = score + metric.get(type) * data.get(type);
            }
        }
        return score;
    }
}
