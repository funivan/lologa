package org.funivan.lologa.tiles.Filter;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Tile;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PositionFilterTest {
    @Test
    public void positive() {
        MatcherAssert.assertThat(
            "Tile located at the same position",
            new PositionFilter(new ListOf<>(new Position(0, 1))),
            new FilterMatcher(
                FilterMatcher.RESULT.PASS,
                new Tile(Color.BLACK, new Position(0, 1))
            )
        );
    }

    @Test
    public void negative() {
        MatcherAssert.assertThat(
            "Tile located at another position",
            new PositionFilter(new ListOf<>(new Position(5, 6))),
            new FilterMatcher(
                FilterMatcher.RESULT.SKIP,
                new Tile(Color.BLUE, new Position(0, 0))
            )
        );
    }
}