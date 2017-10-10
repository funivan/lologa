package org.funivan.lologa.tile.Visitor.Collect;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class TilesMatcher extends TypeSafeDiagnosingMatcher<TilesInterface> {

    private ListOf<TileInterface> original;

    public TilesMatcher(TilesInterface original) {
        this.original = new ListOf<>(original.all());
    }

    @Override
    protected boolean matchesSafely(TilesInterface tiles, Description description) {
        boolean result = true;
        final ListOf<TileInterface> compared = new ListOf<>(tiles.all());
        if (compared.size() != this.original.size()) {
            result = false;
            description.appendText("size of tiles is different. Expect " + this.original.size() + " but current size is " + compared.size());
        } else {

        }
        return result;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Tiles should be same");
    }
}
