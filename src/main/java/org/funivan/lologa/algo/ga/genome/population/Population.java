package org.funivan.lologa.algo.ga.genome.population;

import org.funivan.lologa.algo.ga.genome.population.rand.FixedRandomize;
import org.funivan.lologa.algo.ga.genome.population.rand.RandomizeInterface;
import org.funivan.lologa.algo.ga.player.PlayerInterface;

import java.util.HashMap;
import java.util.Random;

public class Population implements PopulationInterface {

    private final Random rand;
    private final RandomizeInterface randomize;

    public Population(RandomizeInterface randomize) {
        this.randomize = randomize;
        this.rand = new Random();

    }

    public Population() {
        this(new FixedRandomize(0.001));
    }

    @Override
    public PlayerInterface populate(PlayerInterface father, PlayerInterface mother) {
        @SuppressWarnings("unchecked") HashMap<String, Double> genome = (HashMap<String, Double>) father.genome().clone();
        for (final String type : genome.keySet()) {
            if (mother.genome().containsKey(type) && this.rand.nextInt(100) > 50) {
                genome.put(type, mother.genome().get(type));
            }
        }
        // mix data
        for (final String type : genome.keySet()) {
            genome.put(
                type,
                genome.get(type) * this.randomize.next()
            );
        }
        return father.withGenome(genome);
    }
}
