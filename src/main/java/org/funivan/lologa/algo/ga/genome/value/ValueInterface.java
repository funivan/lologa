package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.tiles.TilesInterface;

public interface ValueInterface {

    String type();

    Double value(TilesInterface tiles);
}
