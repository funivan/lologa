package org.funivan.lologa.algo.ga.genome.population.crossing;

import org.funivan.lologa.algo.ga.genome.GenomeInterface;

import java.util.HashMap;

public interface CrossingInterface {
    HashMap<String, Double> cross(GenomeInterface father, GenomeInterface mother);
}
