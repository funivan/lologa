package org.funivan.lologa.algo.multiple;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;
import org.funivan.lologa.tiles.TilesList;
import org.funivan.lologa.tiles.TilesMatcher;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

public class AllConnectedFinderTest {
    @Test
    public void findAll() {
        TilesInterface tiles = new Tiles();
        tiles = tiles.with(new Tile(Color.BLACK, new Position(0, 0))).with(new Tile(Color.RED, new Position(0, 1)));
        tiles = tiles.with(new Tile(Color.BLACK, new Position(1, 0))).with(new Tile(Color.RED, new Position(1, 1)));
        tiles = tiles.with(new Tile(Color.RED, new Position(2, 0))).with(new Tile(Color.RED, new Position(2, 1)));

        MatcherAssert.assertThat(
            "Can not find all same tiles",
            new AllConnectedFinder(
                new Tile(Color.RED, new Position(2, 0))
            ).find(tiles),
            new TilesMatcher(
                new TilesList(
                    new Tile(Color.RED, new Position(2, 0)),
                    new Tile(Color.RED, new Position(2, 1)),
                    new Tile(Color.RED, new Position(1, 1)),
                    new Tile(Color.RED, new Position(0, 1))
                )
            )
        );
    }

    @Test
    public void findNextConnected() {
        MatcherAssert.assertThat(
            "Can not find first connected tile",
            new AllConnectedFinder(
                new Tile(Color.BLACK, new Position(0, 1))
            ).find(
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 0))).with(new Tile(Color.BLACK, new Position(0, 1)))
            ),
            new TilesMatcher(
                new TilesList(
                    new Tile(Color.BLACK, new Position(0, 0)),
                    new Tile(Color.BLACK, new Position(0, 1))
                )
            )
        );
    }
}