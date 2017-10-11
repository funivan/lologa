package org.funivan.lologa.tile.Score;

import org.funivan.lologa.tile.TileInterface;

public class TilesScore implements ScoreInterface {
    private Iterable<TileInterface> tiles;

    public TilesScore(Iterable<TileInterface> tiles) {
        this.tiles = tiles;
    }

    @Override
    public int value() {
        int score = 0;
        for (TileInterface tile : this.tiles) {
            score = score + tile.score().value();
        }
        return score;
    }
}
