package org.funivan.lologa.algo.find;

import org.funivan.lologa.algo.find.multiple.DirectConnectedFinder;
import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesMatcher;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

public class DirectConnectedFinderTest {
    @Test
    public void findRight() {
        MatcherAssert.assertThat(
            "Can not perform same tile at the right",
            new DirectConnectedFinder(
                new Tile(Color.BLACK, new Position(0, 0))
            ).perform(
                new Tiles().with(new Tile(Color.BLACK, new Position(0, 1)))
            ),
            new TilesMatcher(
                new Tiles().with(new Tile(Color.BLACK, new Position(0, 1)))
            )
        );
    }

    @Test
    public void findAll() {
        MatcherAssert.assertThat(
            "Can not perform same tiles at all positions",
            new DirectConnectedFinder(
                new Tile(Color.BLACK, new Position(1, 1))
            ).perform(
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 0))).with(new Tile(Color.BLACK, new Position(0, 1))).with(new Tile(Color.BLACK, new Position(0, 2)))
                    .with(new Tile(Color.BLACK, new Position(1, 0))).with(new Tile(Color.BLACK, new Position(1, 1))).with(new Tile(Color.BLACK, new Position(1, 2)))
                    .with(new Tile(Color.BLACK, new Position(2, 0))).with(new Tile(Color.BLACK, new Position(2, 1))).with(new Tile(Color.BLACK, new Position(2, 2)))
            ),
            new TilesMatcher(
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 1)))
                    .with(new Tile(Color.BLACK, new Position(1, 2)))
                    .with(new Tile(Color.BLACK, new Position(2, 1)))
                    .with(new Tile(Color.BLACK, new Position(1, 0)))
            )
        );
    }
}