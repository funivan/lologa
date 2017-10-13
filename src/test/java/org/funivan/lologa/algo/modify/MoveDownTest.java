package org.funivan.lologa.algo.modify;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Score.Score;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesMatcher;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

public class MoveDownTest {
    @Test
    public void replaceSingleBottomItemTile() {
        MatcherAssert.assertThat(
            "Single bottom tile will be removed",
            new MoveDown(
                new Tiles().with(new Tile(Color.GREEN, new Position(1, 0)))
            ).handle(
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 0))).with(new Tile(Color.GRAY, new Position(0, 1)))
                    .with(new Tile(Color.GREEN, new Position(1, 0))).with(new Tile(Color.RED, new Position(1, 1)))
            ),
            new TilesMatcher(
                new Tiles()
                    /*  should be removed     */.with(new Tile(Color.GRAY, new Position(0, 1)))
                    .with(new Tile(Color.BLACK, new Position(1, 0))).with(new Tile(Color.RED, new Position(1, 1)))
            )
        );
    }

    @Test
    public void replaceTwoTopInRow() {
        MatcherAssert.assertThat(
            "Two top tiles located in one row tile will be removed",
            new MoveDown(
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 0))).with(new Tile(Color.GRAY, new Position(0, 1)))
            ).handle(
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 0))).with(new Tile(Color.GRAY, new Position(0, 1)))
                    .with(new Tile(Color.GREEN, new Position(1, 0))).with(new Tile(Color.RED, new Position(1, 1)))
            ),
            new TilesMatcher(
                new Tiles()
                    /*  should be removed     */                /* should be removed*/
                    .with(new Tile(Color.GREEN, new Position(1, 1))).with(new Tile(Color.RED, new Position(1, 1)))
            )
        );
    }

    @Test
    public void replaceWholeBottomRow() {
        MatcherAssert.assertThat(
            "Can not without 1x0 and 1x1 tiles in the row",
            new MoveDown(
                new Tiles()
                    .with(new Tile(Color.GREEN, new Score(2), new Position(1, 0))).with(new Tile(Color.RED, new Score(3), new Position(1, 1)))
            )
                .handle(
                    new Tiles()
                        .with(new Tile(Color.BLUE, new Score(0), new Position(0, 0))).with(new Tile(Color.BLACK, new Score(1), new Position(0, 1)))
                        .with(new Tile(Color.GREEN, new Score(2), new Position(1, 0))).with(new Tile(Color.RED, new Score(3), new Position(1, 1)))
                ),
            new TilesMatcher(
                new Tiles()
                    .with(new Tile(Color.BLUE, new Score(0), new Position(1, 0))).with(new Tile(Color.BLACK, new Score(1), new Position(1, 1)))
            )
        );
    }

    @Test
    public void replaceWholeTopRow() {
        MatcherAssert.assertThat(
            "Tiles in top (0x0, 0x1) row will be removed ",
            new MoveDown(
                new Tiles()
                    .with(new Tile(Color.BLUE, new Position(0, 0))).with(new Tile(Color.BLACK, new Position(0, 1)))
            ).handle(
                new Tiles()
                    .with(new Tile(Color.BLUE, new Position(0, 0))).with(new Tile(Color.BLACK, new Position(0, 1)))
                    .with(new Tile(Color.GREEN, new Position(1, 0))).with(new Tile(Color.RED, new Position(1, 1))
                )
            ),
            new TilesMatcher(
                new Tiles()
                    .with(new Tile(Color.GREEN, new Position(1, 0))).with(new Tile(Color.RED, new Position(1, 1)))
            )
        );
    }

    @Test
    public void replaceWholeCol() {
        MatcherAssert.assertThat(
            "All col will be removed",
            new MoveDown(
                new Tiles()
                    .with(new Tile(Color.BLUE, new Position(0, 0)))
                    .with(new Tile(Color.GREEN, new Position(1, 0)))
            ).handle(
                new Tiles()
                    .with(new Tile(Color.BLUE, new Position(0, 0))).with(new Tile(Color.BLACK, new Position(0, 1)))
                    .with(new Tile(Color.GREEN, new Position(1, 0))).with(new Tile(Color.RED, new Position(1, 1)))
            ),
            new TilesMatcher(
                new Tiles()
                    /* should be removed                          */.with(new Tile(Color.BLACK, new Position(0, 1)))
                    /* should be removed                           */.with(new Tile(Color.RED, new Position(1, 1)))
            )
        );
    }

    @Test
    public void replaceTwoInCol() {
        MatcherAssert.assertThat(
            "Can not without 1x0 and 2x0 tiles",
            new MoveDown(
                new Tiles()
                    .with(new Tile(Color.GREEN, new Position(1, 0)))
                    .with(new Tile(Color.GRAY, new Position(2, 0)))
            ).handle(
                new Tiles()
                    .with(new Tile(Color.BLUE, new Position(0, 0))).with(new Tile(Color.BLACK, new Position(0, 1)))
                    .with(new Tile(Color.GREEN, new Position(1, 0))).with(new Tile(Color.RED, new Position(1, 1)))
                    .with(new Tile(Color.GRAY, new Position(2, 0))).with(new Tile(Color.LIGHT_GRAY, new Position(2, 1)))
            ),
            new TilesMatcher(
                new Tiles()
                    /* empty                                     */.with(new Tile(Color.BLACK, new Position(0, 1)))
                    /* empty                                     */.with(new Tile(Color.RED, new Position(1, 1)))
                    .with(new Tile(Color.BLUE, new Position(2, 0))).with(new Tile(Color.LIGHT_GRAY, new Position(2, 1)))
            )
        );
    }
}