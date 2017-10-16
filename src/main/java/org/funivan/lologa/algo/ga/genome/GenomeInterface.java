package org.funivan.lologa.algo.ga.genome;

import org.funivan.lologa.algo.find.one.TileFinder;

import java.util.HashMap;

public interface GenomeInterface extends TileFinder {

    GenomeInterface withData(HashMap<String, Double> genome);

    HashMap<String, Double> data();

}
