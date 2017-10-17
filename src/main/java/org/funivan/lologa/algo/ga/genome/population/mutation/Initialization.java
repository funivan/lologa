package org.funivan.lologa.algo.ga.genome.population.mutation;

import java.util.HashMap;
import java.util.Random;

public class Initialization implements RandomizeInterface {
    private final Random random;

    public Initialization() {
        this.random = new Random();
    }


    @Override
    public HashMap<String, Double> mix(HashMap<String, Double> values) {
        HashMap<String, Double> result = new HashMap<>();
        for (final String type : values.keySet()) {
            result.put(type, this.random.nextDouble() - 0.5);
        }
        return result;
    }
}
