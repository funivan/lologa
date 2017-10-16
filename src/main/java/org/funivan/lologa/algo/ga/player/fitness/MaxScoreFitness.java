package org.funivan.lologa.algo.ga.player.fitness;

public class MaxScoreFitness implements FitnessInterface {
    @Override
    public int score(Iterable<Integer> scores) {
        int max = 0;
        for (final Integer score : scores) {
            max = score > max ? score : max;
        }
        return max;
    }

}
