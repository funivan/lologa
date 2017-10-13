package org.funivan.lologa.tiles;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public class TilesMatcher extends TypeSafeDiagnosingMatcher<Iterable<TileInterface>> {

    private ListOf<TileInterface> original;

    public TilesMatcher(Iterable<TileInterface> original) {
        this.original = new ListOf<>(original);
    }

    @Override
    protected boolean matchesSafely(Iterable<TileInterface> tiles, Description description) {
        boolean result = true;
        final ListOf<TileInterface> compared = new ListOf<>(tiles);
        if (compared.size() != this.original.size()) {
            result = false;
            description.appendText("size of tiles is different. Expect " + this.original.size() + " but current size is " + compared.size());
        }
        for (TileInterface originTile : this.original) {
            boolean hasSameTile = false;
            for (TileInterface tile : tiles) {
                if (originTile.same(tile)) {
                    hasSameTile = true;
                    break;
                }
            }
            if (!hasSameTile) {
                result = false;
                description.appendText(" does not match tile " + originTile.toString());
                break;
            }
        }
        return result;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("TilesList should be same");
    }
}
