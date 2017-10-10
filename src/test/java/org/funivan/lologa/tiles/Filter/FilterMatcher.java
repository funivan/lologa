package org.funivan.lologa.tiles.Filter;

import org.cactoos.Func;
import org.funivan.lologa.tile.TileInterface;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class FilterMatcher extends TypeSafeDiagnosingMatcher<Func<TileInterface, Boolean>> {

    private final TileInterface tile;
    private final RESULT expect;

    public enum RESULT {
        PASS, SKIP
    }

    public FilterMatcher(RESULT expect, TileInterface tile) {
        this.tile = tile;
        this.expect = expect;
    }

    @Override
    protected boolean matchesSafely(Func<TileInterface, Boolean> filter, Description description) {
        boolean result;
        boolean expect = this.expect == RESULT.PASS;
        try {
            result = filter.apply(this.tile) == expect;
        } catch (Exception e) {
            description.appendText("filter failed with exception " + e.getMessage());
            result = false;
        }
        description.appendText(
            expect ? "rejected" : "accepted"
        ).appendText(" by filter");

        return result;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Tiles should be "
            + (this.expect == RESULT.PASS ? "accepted" : "rejected")
        );
    }
}
