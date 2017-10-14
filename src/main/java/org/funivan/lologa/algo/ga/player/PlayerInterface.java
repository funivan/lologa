package org.funivan.lologa.algo.ga.player;

import org.funivan.lologa.algo.find.one.TileFinder;
import org.funivan.lologa.algo.ga.fitness.FitnessInterface;
import org.funivan.lologa.tiles.TilesInterface;

public interface PlayerInterface extends TileFinder {
    FitnessInterface fitness(TilesInterface tiles);
}
