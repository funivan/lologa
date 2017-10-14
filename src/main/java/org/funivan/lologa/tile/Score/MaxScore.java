package org.funivan.lologa.tile.Score;

import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

public class MaxScore implements ScoreInterface {
    private final Iterable<TileInterface> tiles;

    public MaxScore(Iterable<TileInterface> tiles) {
        this.tiles = tiles;
    }
    public MaxScore(TilesInterface tiles) {
        this.tiles = tiles.all();
    }

    @Override
    public int value() {
        int score = 0;
        for (TileInterface tile : this.tiles) {
            final int tileScore = tile.score().value();
            score = tileScore > score ? tileScore : score;
        }
        return score;
    }

    @Override
    public String toString() {
        return "Score{" + this.value() + '}';
    }
}
