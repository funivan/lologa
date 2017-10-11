package org.funivan.lologa.tiles.Filter;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Tile;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

public class PositionExcludedTest {
    @Test
    public void positive() {
        MatcherAssert.assertThat(
            "Tile located at the same position",
            new PositionExcluded(new Position(0, 1)),
            new FilterMatcher(
                TileFilterInterface.EXPECT.Positive,
                new Tile(Color.BLACK, new Position(1, 1))
            )
        );
    }
}