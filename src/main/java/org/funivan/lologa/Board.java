package org.funivan.lologa;

import org.cactoos.iterable.LengthOf;
import org.funivan.lologa.algo.multiple.AllConnectedFinder;
import org.funivan.lologa.algo.multiple.one.MaxBottom;
import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Score.Score;
import org.funivan.lologa.tile.Score.TilesScore;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

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

            TileInterface tile;
            if (!this.tiles.has(position)) {
                tile = new Tile(iterator.next(), new Score(1), position);
                this.tiles = this.tiles.with(tile);
                this.addMouseListener(
                    new TileClickListener(this, position, new Point(x, y), new Point(x + size, y + size))
                );
            } else {
                tile = this.tiles.get(position);
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
        this.tiles = tiles;
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

                if (tiles.has(this.position)) {
                    final TileInterface clicked = tiles.get(this.position);
                    final Iterable<TileInterface> connected = new AllConnectedFinder(clicked).find(tiles);

                    if (new LengthOf(connected).value() >= 2) {
                        TilesScore score = new TilesScore(connected);
                        TileInterface bottom = new MaxBottom(clicked).find(tiles);
                        tiles = tiles.with(new Tile(bottom.color(), score, bottom.position()));
                        this.board.paint(tiles);
                    }


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
