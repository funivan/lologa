package org.funivan.lologa.algo.ga.player;

import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.algo.ga.player.round.Round;
import org.funivan.lologa.board.BoardInterface;

public class Player implements PlayerInterface {


    private final BoardInterface board;
    private final GenomeInterface genome;

    private Integer score;

    public Player(final GenomeInterface genome, final BoardInterface board) {
        this.genome = genome;
        this.score = null;
        this.board = board;
    }

    @Override
    public GenomeInterface genome() {
        return this.genome;
    }

    @Override
    public int score() {
        if (this.score == null) {
            this.score = 0;
            this.score = new Round().play(this.genome(), this.board);
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
