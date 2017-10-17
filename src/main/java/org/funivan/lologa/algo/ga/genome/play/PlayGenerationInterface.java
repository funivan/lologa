package org.funivan.lologa.algo.ga.genome.play;

import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.algo.ga.player.PlayerInterface;

public interface PlayGenerationInterface {
    Iterable<PlayerInterface> play(Iterable<GenomeInterface> genomes);
}
