package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.tile.position.Position;
import org.funivan.lologa.tile.Score.Score;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tiles.Tiles;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class AverageScoreValueTest {
    @Test
    public void positiveScoreChange() {
        MatcherAssert.assertThat(
            "Half of tiles should be unlocked 50% of profit",
            new AverageScoreValue()
                .value(
                    new Tiles()
                        .with(new Tile(new Score(4), new Position(0, 0)))
                        .with(new Tile(new Score(1), new Position(1, 0)))
                        .with(new Tile(new Score(1), new Position(2, 0))) // av = 2
                    ,
                    new Tiles()
                        .with(new Tile(new Score(6), new Position(0, 0)))
                        .with(new Tile(new Score(2), new Position(1, 0)))
                ),
            Matchers.is(
                (6.0 + 2.0) / 2.0 - (4.0 + 1.0 + 1.0) / 3.0)
        );
    }
}