package org.funivan.lologa.algo.ga.genome.population.mutation;

import java.util.HashMap;
import java.util.Random;

public class Randomize implements RandomizeInterface {
    private final double mix;
    private final Random random;

    public Randomize(double mix) {
        this.random = new Random();
        this.mix = mix;
    }


    @Override
    public HashMap<String, Double> mix(HashMap<String, Double> values) {


        HashMap<String, Double> result = new HashMap<>();
        for (final String type : values.keySet()) {
            double modifier = this.random.nextInt(10) * this.mix;
            double diff = values.get(type) * modifier;
            if (this.random.nextInt(10) > 5) {
                diff = diff * -1.0;
            }
            result.put(type, values.get(type) + diff);
        }
        return result;
    }
}
