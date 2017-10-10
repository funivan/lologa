package org.funivan.lologa.tiles.Filter;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Tile;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;


public class ColorFilterTest {
    @Test
    public void positive() {
        MatcherAssert.assertThat(
            "Tile contains the same color",
            new ColorFilter(Color.BLACK),
            new FilterMatcher(
                FilterMatcher.RESULT.PASS,
                new Tile(Color.BLACK, new Position(0, 0))
            )
        );
    }

    @Test
    public void negative() {
        MatcherAssert.assertThat(
            "Tile contains different color",
            new ColorFilter(Color.BLACK),
            new FilterMatcher(
                FilterMatcher.RESULT.SKIP,
                new Tile(Color.RED, new Position(0, 0))
            )
        );
    }
}