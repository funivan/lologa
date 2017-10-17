package org.funivan.lologa.algo.ga.genome.population.crossing;

import org.funivan.lologa.algo.ga.genome.GenomeInterface;

import java.util.HashMap;

@SuppressWarnings("unused")
public class HalfCross implements CrossingInterface {

    public HalfCross() {
    }

    @Override
    public HashMap<String, Double> cross(GenomeInterface father, GenomeInterface mother) {
        HashMap<String, Double> result = new HashMap<>();
        boolean takeMother = false;
        for (final String type : father.data().keySet()) {
            final GenomeInterface target = (takeMother ? mother : father);
            result.put(type, target.data().get(type));
            takeMother = !takeMother;
        }
        return result;
    }


}
