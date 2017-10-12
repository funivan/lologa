package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Tile;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

public class MovedDownTest {
    @Test
    public void replaceSingleTile() {
        MatcherAssert.assertThat(
            "Can not remove 1x0 tile",
            new MovedDown(
                new Tiles(
                    new Tile(Color.BLACK, new Position(0, 0)), new Tile(Color.BLACK, new Position(0, 1)),
                    new Tile(Color.GREEN, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1))
                ),
                new Tiles(
                    new Tile(Color.GREEN, new Position(1, 0)) // Should be replaced
                )
            ),
            new TilesMatcher(
                new Tiles(
                    /*  should be removed     */               new Tile(Color.BLACK, new Position(0, 1)),
                    new Tile(Color.GREEN, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1))
                )
            )
        );
    }
    @Test
    public void replaceWholeRowTile() {
        MatcherAssert.assertThat(
            "Can not remove 1x0 tile",
            new MovedDown(
                new Tiles(
                    new Tile(Color.BLUE, new Position(0, 0)), new Tile(Color.BLACK, new Position(0, 1)),
                    new Tile(Color.GREEN, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1))
                ),
                new Tiles(
                    new Tile(Color.GREEN, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1))
                )
            ),
            new TilesMatcher(
                new Tiles(
                    new Tile(Color.BLUE, new Position(1, 1)), new Tile(Color.BLACK, new Position(1, 1))
                )
            )
        );
    }
}