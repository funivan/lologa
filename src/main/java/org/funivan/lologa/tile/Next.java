package org.funivan.lologa.tile;

import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Score.ScoreInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.DirectionInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.awt.*;

public class Next implements TileInterface {
    private TileInterface found = null;
    private final DirectionInterface direction;
    private final TilesInterface tiles;

    public Next(DirectionInterface direction, TilesInterface tiles) {
        this.direction = direction;
        this.tiles = tiles;
    }

    @Override
    public Color color() {
        return this.find().color();
    }

    @Override
    public ScoreInterface score() {
        return this.find().score();
    }


    @Override
    public PositionInterface position() {
        return this.find().position();
    }

    @Override
    public boolean same(TileInterface target) {
        return this.find().same(target);
    }

    private TileInterface find() {
        if (this.found == null) {
            this.found = new AtPosition(
                this.direction.position(),
                this.tiles
            );
        }
        return this.found;
    }
}
