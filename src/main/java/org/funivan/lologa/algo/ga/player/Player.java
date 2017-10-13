package org.funivan.lologa.algo.ga.player;

import org.funivan.lologa.algo.ga.fitness.Fitness;
import org.funivan.lologa.algo.ga.fitness.FitnessInterface;
import org.funivan.lologa.tile.Score.MaxScore;
import org.funivan.lologa.tiles.TilesInterface;

public class Player implements PlayerInterface {

    private TilesInterface tiles;

    public Player(TilesInterface tiles) {
        this.tiles = tiles;
    }

    @Override
    public FitnessInterface fitness() {
        return new Fitness(
            new MaxScore(this.tiles.all()).value()
        );
    }
}
