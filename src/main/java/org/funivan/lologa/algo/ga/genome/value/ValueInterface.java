package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.tiles.TilesInterface;

import java.util.Objects;

public interface ValueInterface {

    String type();

    Double value(TilesInterface original, TilesInterface tiles);

}
