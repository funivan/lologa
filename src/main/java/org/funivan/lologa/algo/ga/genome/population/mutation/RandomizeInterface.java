package org.funivan.lologa.algo.ga.genome.population.mutation;

import java.util.HashMap;

public interface RandomizeInterface {
    HashMap<String, Double> mix(HashMap<String, Double> values);
}
