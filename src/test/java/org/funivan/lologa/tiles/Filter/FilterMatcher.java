package org.funivan.lologa.tiles.Filter;

import org.cactoos.Func;
import org.funivan.lologa.tile.TileInterface;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class FilterMatcher extends TypeSafeDiagnosingMatcher<TileFilterInterface> {

    private final TileInterface tile;
    private final TileFilterInterface.EXPECT expect;

    public FilterMatcher(TileFilterInterface.EXPECT expect, TileInterface tile) {
        this.tile = tile;
        this.expect = expect;
    }

    @Override
    protected boolean matchesSafely(TileFilterInterface filter, Description description) {
        boolean result;
        boolean expect = this.expect == TileFilterInterface.EXPECT.Same;
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
            + (this.expect == TileFilterInterface.EXPECT.Same ? "accepted" : "rejected")
        );
    }
}
