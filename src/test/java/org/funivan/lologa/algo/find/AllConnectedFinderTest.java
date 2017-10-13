package org.funivan.lologa.algo.find;

import org.funivan.lologa.algo.find.multiple.AllConnectedFinder;
import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesMatcher;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

public class AllConnectedFinderTest {
    @Test
    public void findAll() {


        MatcherAssert.assertThat(
            "Can not perform all same tiles",
            new AllConnectedFinder(
                new Tile(Color.RED, new Position(2, 0))
            ).perform(
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 0))).with(new Tile(Color.RED, new Position(0, 1)))
                    .with(new Tile(Color.BLACK, new Position(1, 0))).with(new Tile(Color.RED, new Position(1, 1)))
                    .with(new Tile(Color.RED, new Position(2, 0))).with(new Tile(Color.RED, new Position(2, 1)))
            ),
            new TilesMatcher(
                new Tiles()
                    .with(new Tile(Color.RED, new Position(2, 0)))
                    .with(new Tile(Color.RED, new Position(2, 1)))
                    .with(new Tile(Color.RED, new Position(1, 1)))
                    .with(new Tile(Color.RED, new Position(0, 1)))
            )
        );
    }

    @Test
    public void findNextConnected() {
        MatcherAssert.assertThat(
            "Can not perform first connected tile",
            new AllConnectedFinder(
                new Tile(Color.BLACK, new Position(0, 1))
            ).perform(
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 0))).with(new Tile(Color.BLACK, new Position(0, 1)))
            ),
            new TilesMatcher(
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 0)))
                    .with(new Tile(Color.BLACK, new Position(0, 1)))
            )
        );
    }
}