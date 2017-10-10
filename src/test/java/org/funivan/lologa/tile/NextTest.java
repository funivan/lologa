package org.funivan.lologa.tile;

import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Visitor.Collect.SameConnected;
import org.funivan.lologa.tile.Visitor.Collect.TilesMatcher;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Right;
import org.funivan.lologa.tiles.Tiles;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class NextTest {
    @Test
    public void positive() {
        MatcherAssert.assertThat(
            "Next right tile should be same",
            new Next(
                new Right(new Position(0, 0)),
                new Tiles(
                    new Tile(Color.BLACK, new Position(0, 1))
                )
            ),
            new TileMatcher(
                new Tile(Color.BLACK, new Position(0, 1))
            )
        );
    }
}