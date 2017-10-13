package org.funivan.lologa.tile.Position;


import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class PositionMatcher extends TypeSafeDiagnosingMatcher<PositionInterface> {
    private final PositionInterface expect;


    public PositionMatcher(PositionInterface expect) {
        this.expect = expect;
    }

    @Override
    protected boolean matchesSafely(PositionInterface target, Description description) {
        description.appendText("target position is different " + target.toString());
        return this.expect.equals(target);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Tile should be similar to " + this.expect.toString());
    }
}
