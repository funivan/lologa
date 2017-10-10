package org.funivan.lologa.tile.Position;

import org.funivan.lologa.tile.Next;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileMatcher;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Right;
import org.funivan.lologa.tiles.Tiles;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void samePositive() {
        MatcherAssert.assertThat(
            "Position should be same",
            new Position(0, 0),
            new PositionMatcher(
                new Position(0, 0)
            )
        );
    }


}