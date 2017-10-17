package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.TileInterface;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class TilesMatcher extends TypeSafeDiagnosingMatcher<TilesInterface> {

    private final TilesInterface original;

    public TilesMatcher(TilesInterface original) {
        this.original = original;
    }

    @Override
    protected boolean matchesSafely(TilesInterface tiles, Description description) {
        boolean result = true;
        for (TileInterface origin : this.original.all()) {
            if (!tiles.has(origin.position())) {
                result = false;
                description.appendText(" does not contain tile in position " + origin.position());
                break;
            }
            TileInterface target = tiles.get(origin.position());
            if (!origin.equals(target)) {
                result = false;
                description.appendText(" tiles is different. \n"
                    + "    Expect  " + origin + "\n"
                    + "    Instead " + target
                );
                break;
            }
        }
        return result;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Tiles should be same");
    }
}
