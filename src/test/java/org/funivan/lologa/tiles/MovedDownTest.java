package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Tile;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

public class MovedDownTest {
    @Test
    public void positive() {
        MatcherAssert.assertThat(
            "Can not move tiles down",
            new MovedDown(
                new Tiles(
                    new Tile(Color.RED, new Position(0, 0)), new Tile(Color.GRAY, new Position(0, 1)),
                    /*    should be placed here        */     new Tile(Color.BLACK, new Position(1, 1))
                )
            ),
            new TilesMatcher(
                new Tiles(
                    /*    empty cel                     */     new Tile(Color.GRAY, new Position(0, 1)),
                    new Tile(Color.RED, new Position(1, 0)), new Tile(Color.BLACK, new Position(1, 1))
                )
            )
        );
    }
}