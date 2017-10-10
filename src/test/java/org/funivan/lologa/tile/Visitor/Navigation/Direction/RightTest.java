package org.funivan.lologa.tile.Visitor.Navigation.Direction;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionMatcher;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RightTest {
    @Test
    public void position() {
        MatcherAssert.assertThat(
            "Position should be 0x1",
            new Right(
                new Position(0, 0)
            ).position(),
            new PositionMatcher(
                new Position(0, 1)
            )
        );
    }
}