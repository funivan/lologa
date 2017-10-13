package org.funivan.lologa.algo.ga.fitness;

public class Fitness implements FitnessInterface {
    private final int score;

    public Fitness(int score) {
        this.score = score;
    }

    public int value() {
        return this.score;
    }

}
