package org.funivan.lologa.tile;

import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Score.ScoreInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;
import org.funivan.lologa.tiles.TilesInterface;

import java.awt.*;

public class MaxNextBottom implements TileInterface {
    private TileInterface found = null;
    private TileInterface start;
    private final TilesInterface tiles;

    public MaxNextBottom(TileInterface start, TilesInterface tiles) {
        this.start = start;
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
            TileInterface bottom = this.start;
            do {
                TileInterface next = new Next(new Bottom(bottom), this.tiles);
                boolean sameColor = next.color().equals(bottom.color());
                if (next.same(Tile.DUMMY) || !sameColor) {
                    break;
                }
                bottom = next;
            } while (true);
            this.found = bottom;
        }
        return this.found;
    }
}
