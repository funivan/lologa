package org.funivan.lologa;

import org.cactoos.io.LengthOf;
import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.Visitor.Collect.SameConnected;
import org.funivan.lologa.tiles.TilesInterface;
import org.funivan.lologa.tile.TilesPool.TilesPoolInterface;
import org.funivan.lologa.tile.Visitor.Collect.AllSameConnected;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;
import org.funivan.lologa.tile.Visitor.Navigation.NextLastSame;

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
        int y = 0;
        for (int index = 0; index < len; index++) {
            int x = (index % rows) * size;
            y = y + ((index > 0 && index % cols == 0) ? size : 0);
            if (!tiles.has(index)) {
                tiles = tiles.set(new Tile(iterator.next(), index, 0));
                this.tilesPool = this.tilesPool.withTiles(tiles);
                this.addMouseListener(
                    new TileClickListener(this, index, new Point(x, y), new Point(x + size, y + size))
                );
            }
            TileInterface tile = tiles.get(index);
            g.setColor(tile.color());
            g.fillRect(x, y, size, size);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, size, size);
            g.drawString("index:" + String.valueOf(index), x + 10, y + 15);
            g.drawString("score:" + String.valueOf(tile.score()), x + 10, y + 30);
        }


    }

    public void paint(TilesPoolInterface tiles) {
        this.tilesPool = tiles;
        this.repaint();
    }

    private static class TileClickListener implements MouseListener {
        private Board board;
        private final int index;
        private final Point start;
        private final Point end;

        public TileClickListener(Board board, int index, Point start, Point end) {
            this.board = board;
            this.index = index;
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

                TileInterface tile = tiles.get(this.index);
                System.out.println("Clicked:" + tile.index());
                TilesInterface connected = new AllSameConnected().collect(tile, this.board.tilesPool);
                int score = 0;
                System.out.println("Connected");
                for (TileInterface target : connected.all()) {
                    System.out.println("Connected: " + target.index());
                    score = score + target.score();
                }
                System.out.println("/Connected");
                TileInterface bottom = new NextLastSame(new Bottom()).navigate(tile, this.board.tilesPool);

                tiles = tiles.set(new Tile(bottom.color(), bottom.index(), score));
                this.board.paint(
                    this.board.tilesPool.withTiles(tiles)
                );
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
