package org.funivan.lologa.algo.ga.player;

import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.algo.ga.player.fitness.FitnessInterface;
import org.funivan.lologa.algo.ga.player.round.Round;
import org.funivan.lologa.board.BoardInterface;

import java.util.ArrayList;

public class Player implements PlayerInterface {


    private final BoardInterface board;
    private final GenomeInterface genome;
    private final FitnessInterface fitness;

    private Integer score;

    public Player(final GenomeInterface genome, final BoardInterface board, final FitnessInterface fitness) {
        this.genome = genome;
        this.score = null;
        this.board = board;
        this.fitness = fitness;
    }

    @Override
    public GenomeInterface genome() {
        return this.genome;
    }

    @Override
    public int score() {
        if (this.score == null) {
            this.score = 0;
            ArrayList<Integer> scores = new ArrayList<>();
            for (int round = 0; round < 4; round++) {
                scores.add(
                    new Round().play(this.genome(), this.board)
                );
            }
            this.score = this.fitness.score(scores);
        }
        return this.score;
    }

    @Override
    public int compareTo(PlayerInterface result) {
        return Integer.compare(result.score(), this.score());
    }

    @Override
    public String toString() {
        return "Score{" + this.score() + '}';
    }

}
