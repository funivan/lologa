package org.funivan.lologa.algo.ga.genome.population;

import org.funivan.lologa.algo.ga.genome.GenomeInterface;

public interface PopulationInterface {

    Iterable<GenomeInterface> populate(Iterable<GenomeInterface> genomes);

}
