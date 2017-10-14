package org.funivan.lologa.algo.gameplay;

import org.cactoos.iterable.LengthOf;
import org.funivan.lologa.algo.find.multiple.AllConnectedFinder;
import org.funivan.lologa.algo.find.one.MaxBottom;
import org.funivan.lologa.algo.modify.MoveDown;
import org.funivan.lologa.tile.Score.ScoreSum;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

public class ClassicGamePlay implements GameplayInterface {


    @Override
    public int minimum() {
        return 3;
    }

    @Override
    public TilesInterface interact(TileInterface tile, TilesInterface tiles) {
        final TilesInterface connected = new AllConnectedFinder(tile).handle(tiles);
        if (new LengthOf(connected.all()).value() >= this.minimum()) {
            ScoreSum score = new ScoreSum(connected.all());
            TileInterface bottom = new MaxBottom(tile).find(tiles);
            TilesInterface move = connected.without(bottom.position());
            tiles = new MoveDown(move).handle(tiles);
            tiles = tiles.with(new Tile(bottom.color(), score, bottom.position()));
        }
        return tiles;
    }
}
