package org.funivan.lologa.algo.ga.genome.population.rand;

public class FixedRandomize implements RandomizeInterface {

    private final double result;

    public FixedRandomize(double result) {
        this.result = result;
    }

    @Override
    public double next() {
        return this.result;
    }
}
