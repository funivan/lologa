package org.funivan.lologa.algo.ga.genome.population.mutation;

import java.util.HashMap;
import java.util.Random;

public class Randomize implements RandomizeInterface {
    private final double step;
    private final double rate;
    private final Random random;

    public Randomize(double rate, double step) {
        this.rate = rate;
        this.step = step;
        this.random = new Random();
    }


    @Override
    public HashMap<String, Double> mix(HashMap<String, Double> values) {


        HashMap<String, Double> result = new HashMap<>();
        for (final String type : values.keySet()) {
            Double value = values.get(type);
            if (this.random.nextDouble()<this.rate) {
                value = value + this.random.nextDouble() * this.step * 2 - this.step;
            }

            result.put(type, value);
        }
        return result;
    }
}
