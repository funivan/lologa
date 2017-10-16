package org.funivan.lologa.algo.ga.player.fitness;

import org.cactoos.iterable.LengthOf;
import org.cactoos.iterable.Limited;
import org.cactoos.iterable.Skipped;
import org.cactoos.iterable.Sorted;

public class MiddleScoreAverageFitness implements FitnessInterface {
    @Override
    public int score(Iterable<Integer> scores) {
        final Integer len = new LengthOf(scores).value();
        final int size = len / 4;
        Iterable<Integer> middleScores = new Limited<>(new Skipped<>(new Sorted<>(scores), size / 2), size);
        double sum = 0;
        for (Integer middleScore : middleScores) {
            sum = sum + middleScore;
        }
        return (int) Math.round(sum / size);
    }

}
