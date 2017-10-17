package org.funivan.lologa.algo.ga.player.round;

import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.board.BoardInterface;
import org.funivan.lologa.tile.Score.ScoreSum;

public class Round implements RoundInterface {

    @Override
    public int play(final GenomeInterface genome, BoardInterface board) {
        int max = 0;
        int moves = 2000;
        do {
            moves--;
            board = board.interact(
                genome.find(
                    board.tiles()
                ).position()
            );
            final int current = new ScoreSum(board.tiles()).value();
            if (current > max) {
                max = current;
            } else {
                break;
            }
        } while (moves > 0);

        return max;
    }
}
