package org.funivan.lologa;

import org.cactoos.iterable.LengthOf;
import org.funivan.lologa.tile.AtPosition;
import org.funivan.lologa.tile.Next;
import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.TilesPool.TilesPoolInterface;
import org.funivan.lologa.tile.Visitor.Collect.AllSameConnected;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

public class Board extends JPanel {

    private TilesPoolInterface tilesPool;
    private final Iterable<Color> colors;

    public Board(TilesPoolInterface tilesPool, Iterable<Color> colors) {
        this.tilesPool = tilesPool;
        this.colors = colors;
        this.setBorder(new LineBorder(Color.black));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final int cols = this.tilesPool.cols();
        final int rows = this.tilesPool.rows();
        TilesInterface tiles = this.tilesPool.tiles();
        final int size = 100;
        final int len = cols * rows;
        Iterator<Color> iterator = this.colors.iterator();
        int row = 0;
        for (int index = 0; index < len; index++) {
            int col = index % rows;
            int x = col * size;
            row = row + ((index > 0 && index % cols == 0) ? 1 : 0);
            int y = row * size;
            final Position position = new Position(row, col);
            if (new AtPosition(position, tiles).same(Tile.DUMMY)) {
                tiles = new Tiles(tiles, new Tile(iterator.next(), 1, position));
                this.tilesPool = this.tilesPool.withTiles(tiles);
                this.addMouseListener(
                    new TileClickListener(this, position, new Point(x, y), new Point(x + size, y + size))
                );
            }
            TileInterface tile = new AtPosition(position, tiles);
            g.setColor(tile.color());
            g.fillRect(x, y, size, size);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, size, size);
            g.drawString("position:" + tile.position().row() + "x" + tile.position().col(), x + 10, y + 15);
            g.drawString("score:" + String.valueOf(tile.score()), x + 10, y + 30);
        }


    }

    public void paint(TilesPoolInterface tiles) {
        this.tilesPool = tiles;
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
            TilesInterface tiles = this.board.tilesPool.tiles();
            if (this.start.getX() < x && this.start.getY() < y && this.end.getX() > x && this.end.getY() > y) {

                TileInterface tile = new AtPosition(this.position, tiles);
                TilesInterface connected = new AllSameConnected().collect(tile, tiles);
                if (new LengthOf(connected.all()).value() >= 1) {
                    int score = 0;
                    for (TileInterface target : connected.all()) {
                        score = score + target.score();
                    }

                    TileInterface bottom = tile;
                    do {
                        TileInterface next = new Next(new Bottom(), tiles, bottom);
                        boolean sameColor = next.color().equals(bottom.color());
                        if (next.same(Tile.DUMMY) || !sameColor) {
                            break;
                        }
                        bottom = next;
                    } while (true);
                    System.out.println("Bottom: " + bottom.position());
                    // Move items down
                    boolean moved = false;
                    Iterable<TileInterface> moveItems = connected.all();
                    do {
                        moved = false;
                        for (TileInterface item : moveItems) {
                            if (!item.equals(bottom)) {
                                System.out.println("Refresh: " + item.position());
                            }
                        }
                    } while (moved);
                    tiles = new Tiles(tiles, new Tile(bottom.color(), score, bottom.position()));
                    this.board.paint(
                        this.board.tilesPool.withTiles(tiles)
                    );
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
