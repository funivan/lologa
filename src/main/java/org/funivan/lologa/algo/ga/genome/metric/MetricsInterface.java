package org.funivan.lologa.algo.ga.genome.metric;

import org.funivan.lologa.tiles.TilesInterface;

import java.util.HashMap;

public interface MetricsInterface {

    HashMap<String, Double> collect(TilesInterface original, TilesInterface tiles);

}
