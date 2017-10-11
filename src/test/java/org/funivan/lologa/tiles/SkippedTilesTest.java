package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Tile;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

public class SkippedTilesTest {
    @Test
    public void positive() {
        MatcherAssert.assertThat(
            "Can not remove tiles located at the same position",
            new SkippedTiles(
                new Tiles(
                    new Tile(Color.BLACK, new Position(0, 0)),
                    new Tile(Color.BLACK, new Position(0, 1))
                ),
                new Tiles(
                    new Tile(Color.RED, new Position(0, 0))
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