package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Tile;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

public final class SameConnectedTest {
    @Test
    public void findRight() {
        MatcherAssert.assertThat(
            "Can not find same tile at the right",
            new SameConnected(
                new Tile(Color.BLACK, new Position(0, 0)),
                new Tiles(
                    new Tile(Color.BLACK, new Position(0, 0)),
                    new Tile(Color.BLACK, new Position(0, 1))
                )
            ),
            new TilesMatcher(
                new Tiles(
                    new Tile(Color.BLACK, new Position(0, 1))
                )
            )
        );
    }

    @Test
    public void emptyResult() {
        MatcherAssert.assertThat(
            "Expect empty result",
            new SameConnected(
                new Tile(Color.BLACK, new Position(0, 0)),
                new Tiles(
                    new Tile(Color.BLACK, new Position(0, 0)),
                    new Tile(Color.BLACK, new Position(0, 1))
                )
            ),
            new TilesMatcher(
                new Tiles(
                    new Tile(Color.BLACK, new Position(0, 1))
                )
            )
        );
    }
}