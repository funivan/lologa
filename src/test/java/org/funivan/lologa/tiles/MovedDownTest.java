package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Score.Score;
import org.funivan.lologa.tile.Tile;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

public class MovedDownTest {
    @Test
    public void replaceSingleBottomItemTile() {
        MatcherAssert.assertThat(
            "Single bottom tile will be removed",
            new MovedDown(
                new Tiles(
                    new Tile(Color.BLACK, new Position(0, 0)), new Tile(Color.GRAY, new Position(0, 1)),
                    new Tile(Color.GREEN, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1))
                ),
                new Tiles(
                    new Tile(Color.GREEN, new Position(1, 0))
                )
            ),
            new TilesMatcher(
                new Tiles(
                    /*  should be removed     */                new Tile(Color.GRAY, new Position(0, 1)),
                    new Tile(Color.BLACK, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1))
                )
            )
        );
    }

    @Test
    public void replaceTwoTopInRow() {
        MatcherAssert.assertThat(
            "Two top tiles located in one row tile will be removed",
            new MovedDown(
                new Tiles(
                    new Tile(Color.BLACK, new Position(0, 0)), new Tile(Color.GRAY, new Position(0, 1)),
                    new Tile(Color.GREEN, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1))
                ),
                new Tiles(
                    new Tile(Color.BLACK, new Position(0, 0)), new Tile(Color.GRAY, new Position(0, 1))
                )
            ),
            new TilesMatcher(
                new Tiles(
                    /*  should be removed     */                /* should be removed*/
                    new Tile(Color.GREEN, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1))
                )
            )
        );
    }

    @Test
    public void replaceWholeBottomRow() {
        MatcherAssert.assertThat(
            "Can not remove 1x0 and 1x1 tiles in the row",
            new MovedDown(
                new Tiles(
                    new Tile(Color.BLUE, new Score(0), new Position(0, 0)), new Tile(Color.BLACK, new Score(1), new Position(0, 1)),
                    new Tile(Color.GREEN, new Score(2), new Position(1, 0)), new Tile(Color.RED, new Score(3), new Position(1, 1))
                ),
                new Tiles(
                    new Tile(Color.GREEN, new Score(2), new Position(1, 0)), new Tile(Color.RED, new Score(3), new Position(1, 1))
                )
            ),
            new TilesMatcher(
                new Tiles(
                    new Tile(Color.BLUE, new Score(0), new Position(1, 0)), new Tile(Color.BLACK, new Score(1), new Position(1, 1))
                )
            )
        );
    }

    @Test
    public void replaceWholeTopRow() {
        MatcherAssert.assertThat(
            "Tiles in top (0x0, 0x1) row will be removed ",
            new MovedDown(
                new Tiles(
                    new Tile(Color.BLUE, new Position(0, 0)), new Tile(Color.BLACK, new Position(0, 1)),
                    new Tile(Color.GREEN, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1))
                ),
                new Tiles(
                    new Tile(Color.BLUE, new Position(0, 0)), new Tile(Color.BLACK, new Position(0, 1))
                )
            ),
            new TilesMatcher(
                new Tiles(
                    new Tile(Color.GREEN, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1))
                )
            )
        );
    }

    @Test
    public void replaceWholeCol() {
        MatcherAssert.assertThat(
            "All col will be removed",
            new MovedDown(
                new Tiles(
                    new Tile(Color.BLUE, new Position(0, 0)), new Tile(Color.BLACK, new Position(0, 1)),
                    new Tile(Color.GREEN, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1))
                ),
                new Tiles(
                    new Tile(Color.BLUE, new Position(0, 0)),
                    new Tile(Color.GREEN, new Position(1, 0))
                )
            ),
            new TilesMatcher(
                new Tiles(
                    /* should be removed */  new Tile(Color.BLACK, new Position(0, 1)),
                    /* should be removed */  new Tile(Color.RED, new Position(1, 1))
                )
            )
        );
    }

    @Test
    public void replaceTwoInCol() {
        MatcherAssert.assertThat(
            "Can not remove 1x0 and 2x0 tiles",
            new MovedDown(
                new Tiles(
                    new Tile(Color.BLUE, new Position(0, 0)), new Tile(Color.BLACK, new Position(0, 1)),
                    new Tile(Color.GREEN, new Position(1, 0)), new Tile(Color.RED, new Position(1, 1)),
                    new Tile(Color.GRAY, new Position(2, 0)), new Tile(Color.LIGHT_GRAY, new Position(2, 1))
                ),
                new Tiles(
                    new Tile(Color.GREEN, new Position(1, 0)),
                    new Tile(Color.GRAY, new Position(2, 0))
                )
            ),
            new TilesMatcher(
                new Tiles(
                    /* empty */                               new Tile(Color.BLACK, new Position(0, 1)),
                    /* empty */                               new Tile(Color.RED, new Position(1, 1)),
                    new Tile(Color.BLUE, new Position(2, 0)), new Tile(Color.LIGHT_GRAY, new Position(2, 1))
                )
            )
        );
    }
}