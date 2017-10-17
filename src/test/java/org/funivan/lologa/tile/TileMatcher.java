package org.funivan.lologa.tile;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class TileMatcher extends TypeSafeDiagnosingMatcher<TileInterface> {
    private final TileInterface expect;


    public TileMatcher(TileInterface expect) {
        this.expect = expect;
    }

    @Override
    protected boolean matchesSafely(TileInterface target, Description description) {
        description.appendText("target tile is different");
        return this.expect.same(target);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Tile should be the same ");
    }
}
