package org.funivan.lologa.algo.ga.player.fitness;

import org.cactoos.iterable.LengthOf;

public class AverageScoreFitness implements FitnessInterface {
    @Override
    public int score(Iterable<Integer> scores) {
        final Integer len = new LengthOf(scores).value();
        int sum = 0;
        for (Integer middleScore : scores) {
            sum = sum + middleScore;
        }
        return Math.round(sum / len);
    }

}
