package org.funivan.lologa.tiles.filter;

import org.funivan.lologa.tile.position.Position;
import org.funivan.lologa.tile.Tile;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

public class PositionFilterTest {
    @Test
    public void positive() {
        MatcherAssert.assertThat(
            "Tile located at the same position",
            new PositionFilter(new Position(0, 1)),
            new FilterMatcher(
                TileFilterInterface.EXPECT.Positive,
                new Tile(Color.BLACK, new Position(0, 1))
            )
        );
    }

    @Test
    public void negative() {
        MatcherAssert.assertThat(
            "Tile located at another position",
            new PositionFilter(new Position(5, 6)),
            new FilterMatcher(
                TileFilterInterface.EXPECT.Negative,
                new Tile(Color.BLUE, new Position(0, 0))
            )
        );
    }
}