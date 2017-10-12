package org.funivan.lologa;

import org.cactoos.iterable.LengthOf;
import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.AtPosition;
import org.funivan.lologa.tile.MaxNextBottom;
import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Score.Score;
import org.funivan.lologa.tile.Score.TilesScore;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

public class Board extends JPanel {

    private TilesInterface tiles;
    private final int rows;
    private final int cols;
    private final Iterable<Color> colors;

    public Board(TilesInterface tiles, int rows, int cols, Iterable<Color> colors) {
        this.tiles = tiles;
        this.rows = rows;
        this.cols = cols;
        this.colors = colors;
        this.setBorder(new LineBorder(Color.black));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final int cols = this.cols;
        final int rows = this.rows;
        final int size = 80;
        final int len = cols * rows;
        Iterator<Color> iterator = this.colors.iterator();
        int row = 0;
        for (int index = 0; index < len; index++) {
            int col = index % rows;
            int x = col * size;
            row = row + ((index > 0 && index % cols == 0) ? 1 : 0);
            int y = row * size;
            final Position position = new Position(row, col);
            TileInterface tile = new AtPosition(position, this.tiles);
            if (tile.same(Tile.DUMMY)) {
                tile = new Tile(iterator.next(), new Score(1), position);
                this.tiles = new JoinedTiles(this.tiles, tile);
                this.addMouseListener(
                    new TileClickListener(this, position, new Point(x, y), new Point(x + size, y + size))
                );
            }
            g.setColor(tile.color());
            g.fillRect(x, y, size, size);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, size, size);
            g.drawString("p:" + tile.position().row() + "x" + tile.position().col(), x + 10, y + 15);
            g.drawString("s:" + String.valueOf(tile.score().value()), x + 10, y + 30);
        }
    }

    public void paint(TilesInterface tiles) {
        System.out.println("Start paint");
        this.tiles = new Tiles(new ListOf<TileInterface>(tiles));
        this.repaint();
    }

    private static class TileClickListener implements MouseListener {
        private Board board;
        private final PositionInterface position;
        private final Point start;
        private final Point end;

        public TileClickListener(Board board, PositionInterface position, Point start, Point end) {
            this.board = board;
            this.position = position;
            this.start = start;
            this.end = end;
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
            final int x = mouseEvent.getPoint().x;
            final int y = mouseEvent.getPoint().y;
            TilesInterface tiles = this.board.tiles;
            if (this.start.getX() < x && this.start.getY() < y && this.end.getX() > x && this.end.getY() > y) {

                TileInterface tile = new AtPosition(this.position, tiles);
                TilesInterface connected = new AllSameConnected(tile, tiles);
                if (new LengthOf(connected).value() >= 2) {
                    TileInterface bottom = new MaxNextBottom(tile, tiles);
                    tiles = new SkippedTiles(tiles, connected);
                    tiles = new MovedDown(tiles, connected);
                    tiles = new JoinedTiles(tiles, new Tile(bottom.color(), new TilesScore(connected), bottom.position()));
                    this.board.paint(tiles);
                }

            }
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }
    }
}
