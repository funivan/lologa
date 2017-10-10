package org.funivan.lologa.tile;

import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.DirectionInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.awt.*;

public class Next implements TileInterface {
    private final DirectionInterface direction;
    private final TilesInterface tiles;
    private final TileInterface original;

    public Next(DirectionInterface direction, TilesInterface tiles, TileInterface original) {
        this.direction = direction;
        this.tiles = tiles;
        this.original = original;
    }

    @Override
    public Color color() {
        return this.find().color();
    }

    @Override
    public int score() {
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
        return new AtPosition(
            this.direction.next(this.original.position()),
            tiles
        );
    }
}
