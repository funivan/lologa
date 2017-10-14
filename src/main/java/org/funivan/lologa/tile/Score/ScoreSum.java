package org.funivan.lologa.tile.Score;

import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

public class ScoreSum implements ScoreInterface {
    private final Iterable<TileInterface> tiles;

    public ScoreSum(Iterable<TileInterface> tiles) {
        this.tiles = tiles;
    }
    public ScoreSum(TilesInterface tiles) {
        this.tiles = tiles.all();
    }

    @Override
    public int value() {
        int score = 0;
        for (TileInterface tile : this.tiles) {
            score = score + tile.score().value();
        }
        return score;
    }

    @Override
    public String toString() {
        return "Score{" + this.value() + '}';
    }
}
