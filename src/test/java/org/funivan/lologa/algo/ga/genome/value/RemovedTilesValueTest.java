package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tiles.Tiles;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.awt.*;

public class RemovedTilesValueTest {
    @Test
    public void removeHalfTiles() {
        MatcherAssert.assertThat(
            "Expect correct tiles value",
            new RemovedTilesValue().value(
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 0)))
                    .with(new Tile(Color.BLACK, new Position(1, 0))),
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(1, 0)))
            ),
            Matchers.is(0.5)
        );
    }

    @Test
    public void sameAsOrigin() {
        MatcherAssert.assertThat(
            "Removed tiles value should be the lowest",
            new RemovedTilesValue().value(
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 0)))
                    .with(new Tile(Color.BLACK, new Position(1, 0))),
                new Tiles()
                    .with(new Tile(Color.BLACK, new Position(0, 0)))
                    .with(new Tile(Color.BLACK, new Position(1, 0)))
            ),
            Matchers.is(0.0)
        );
    }
}