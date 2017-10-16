package org.funivan.lologa.board;

import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Score.Score;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.awt.*;
import java.util.Iterator;

public class Board implements BoardInterface {

    public static final Color GREEN = new Color(100, 200, 100);
    public static final Color RED = new Color(250, 50, 50);
    public static final Color BLUE = new Color(1, 90, 250);
    public static final Color YELLOW = new Color(255, 220, 40);

    private final GameplayInterface gameplay;
    private TilesInterface tiles;
    private final int rows;
    private final int cols;
    private final Iterable<Color> colors;

    public Board(GameplayInterface gameplay, int rows, int cols, Iterable<Color> colors, TilesInterface tiles) {
        this.tiles = tiles;
        this.rows = rows;
        this.cols = cols;
        this.colors = colors;
        this.gameplay = gameplay;
    }

    @Override
    public TilesInterface tiles() {
        final Iterator<Color> colors = this.colors.iterator();
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                final Position position = new Position(row, col);
                if (!this.tiles.has(position)) {
                    this.tiles = this.tiles.with(
                        new Tile(colors.next(), new Score(1), position)
                    );
                }
            }
        }
        return this.tiles;
    }

    @Override
    public BoardInterface interact(PositionInterface position) {
        TilesInterface tiles = this.tiles();
        if (tiles.has(position)) {
            final TileInterface clicked = tiles.get(position);
            tiles = this.gameplay.interact(clicked, tiles);
        }
        return new Board(this.gameplay, this.rows, this.cols, this.colors, tiles);
    }

}
