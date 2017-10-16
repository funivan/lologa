package org.funivan.lologa.algo.ga.player;

import org.funivan.lologa.algo.ga.genome.GenomeInterface;

public interface PlayerInterface extends Comparable<PlayerInterface> {

    GenomeInterface genome();

    int score();


}
