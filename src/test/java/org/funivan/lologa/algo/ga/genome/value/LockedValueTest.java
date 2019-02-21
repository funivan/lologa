package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.algo.gameplay.ClassicGamePlay;
import org.funivan.lologa.tile.position.Position;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tiles.Tiles;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.awt.*;

public class LockedValueTest {
    @Test
    public void halfLocked() {
        MatcherAssert.assertThat(
            "Half of tiles should be unlocked 50% of profit",
            new LockedTiles(new ClassicGamePlay())
                .value(
                    new Tiles()
                        .with(new Tile(Color.RED, new Position(0, 0))).with(new Tile(Color.RED, new Position(0, 1)))
                        .with(new Tile(Color.BLACK, new Position(1, 0))).with(new Tile(Color.RED, new Position(1, 1)))
                        .with(new Tile(Color.RED, new Position(2, 0))).with(new Tile(Color.BLACK, new Position(2, 1)))
                    ,
                    new Tiles()
                        .with(new Tile(Color.RED, new Position(0, 0))).with(new Tile(Color.RED, new Position(0, 1)))
                        .with(new Tile(Color.RED, new Position(1, 0))).with(new Tile(Color.BLACK, new Position(1, 1)))
                        .with(new Tile(Color.BLACK, new Position(2, 0))).with(new Tile(Color.BLACK, new Position(2, 1)))
                ),
            Matchers.is(0.5)
        );
    }

    @Test
    public void allLocked() {
        MatcherAssert.assertThat(
            "All tiles should be locked 0% of profit",
            new LockedTiles(new ClassicGamePlay())
                .value(
                    new Tiles()
                        .with(new Tile(Color.BLACK, new Position(0, 0)))
                        .with(new Tile(Color.RED, new Position(1, 0)))
                    ,
                    new Tiles()
                        .with(new Tile(Color.BLACK, new Position(0, 0)))
                        .with(new Tile(Color.RED, new Position(1, 0)))
                ),
            Matchers.is(0.0)
        );
    }

    @Test
    public void allUnlocked() {
        MatcherAssert.assertThat(
            "All tiles should be unlocked 100% of profit",
            new LockedTiles(new ClassicGamePlay())
                .value(
                    new Tiles()
                        .with(new Tile(Color.BLACK, new Position(0, 0)))
                        .with(new Tile(Color.RED, new Position(1, 0)))
                    ,
                    new Tiles()
                ),
            Matchers.is(1.0)
        );
    }
}