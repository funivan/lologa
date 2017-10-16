package org.funivan.lologa.algo.ga.player.round;

import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.board.BoardInterface;

public interface RoundInterface {
    int play(final GenomeInterface genome, BoardInterface board);
}
