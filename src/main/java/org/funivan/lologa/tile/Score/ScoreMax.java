package org.funivan.lologa.tile.Score;

import org.funivan.lologa.tile.TileInterface;

public class ScoreMax implements ScoreInterface {
    private Iterable<TileInterface> tiles;

    public ScoreMax(Iterable<TileInterface> tiles) {
        this.tiles = tiles;
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
