package org.funivan.lologa.algo.ga.genome.population.crossing;

import org.funivan.lologa.algo.ga.genome.GenomeInterface;

import java.util.HashMap;
import java.util.Random;

public class RandomCross implements CrossingInterface {
    private final Random rand;

    public RandomCross() {
        this.rand = new Random();
    }

    @Override
    public HashMap<String, Double> cross(GenomeInterface father, GenomeInterface mother) {
        HashMap<String, Double> result = new HashMap<>();
        for (final String type : father.data().keySet()) {
            final GenomeInterface target = (this.rand.nextInt(100) > 50) ? father : mother;
            result.put(type, target.data().get(type) );
        }
        return result;
    }


}
