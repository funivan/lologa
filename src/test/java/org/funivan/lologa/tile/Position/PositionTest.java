package org.funivan.lologa.tile.Position;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsSame;
import org.junit.Test;

public class PositionTest {

    @Test
    public void equalsPositive() {
        MatcherAssert.assertThat(
            "Position should be same",
            new Position(0, 0),
            new PositionMatcher(
                new Position(0, 0)
            )
        );
    }

    @Test
    public void equalsNegative() {
        MatcherAssert.assertThat(
            "Position should be different",
            new Position(0, 0),
            new IsNot<>(
                new PositionMatcher(
                    new Position(0, 1)
                )
            )
        );
    }

    @Test
    public void sameHashCode() {
        MatcherAssert.assertThat(
            "Position should have same hashCode",
            new Position(0, 0).hashCode(),
            new IsSame<>(
                new Position(0, 0).hashCode()
            )
        );
    }


}