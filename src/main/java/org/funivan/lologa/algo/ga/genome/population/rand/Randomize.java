package org.funivan.lologa.algo.ga.genome.population.rand;

import java.util.Random;

public class Randomize implements RandomizeInterface {
    private final double precision;
    private final Random random;

    public Randomize(double precision) {
        this.random = new Random();
        this.precision = precision;
    }

    @Override
    public double next() {
        return this.random.nextDouble() * this.precision;
    }
}
