package org.funivan.lologa.gui;

import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.board.BoardInterface;
import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Score.Score;
import org.funivan.lologa.tile.Score.ScoreInterface;
import org.funivan.lologa.tile.Score.ScoreSum;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Iterator;

public class InteractiveBoard extends JPanel implements BoardInterface {

    private final GameplayInterface gameplay;
    private TilesInterface tiles;
    private final int rows;
    private final int cols;
    private final Iterable<Color> colors;
    private final HashMap<PositionInterface, MouseListener> mouseListener = new HashMap<>();

    public InteractiveBoard(GameplayInterface gameplay, int rows, int cols, Iterable<Color> colors) {
        this.tiles = new Tiles();
        this.rows = rows;
        this.cols = cols;
        this.colors = colors;
        this.gameplay = gameplay;
        this.setBorder(new LineBorder(Color.black));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final int size = 80;
        int width = size;
        final TilesInterface tiles = this.tiles();
        for (TileInterface tile : tiles.all()) {
            final PositionInterface position = tile.position();
            int x = position.col() * size;
            int y = position.row() * size;
            if (x + size > width) {
                width = x + size;
            }
            if (!this.mouseListener.containsKey(position)) {
                final TileClickListener listener = new TileClickListener(this, position, new Point(x, y), new Point(x + size, y + size));
                this.addMouseListener(listener);
                this.mouseListener.put(position, listener);
            }
            g.setColor(tile.color());
            g.fillRect(x, y, size, size);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, size, size);
            g.setColor(new Color(215, 215, 215));
            g.drawString("" + String.valueOf(tile.score().value()), x + size / 2, y + size / 2);
        }

        g.setColor(Color.BLACK);
        HashMap<String, ScoreInterface> metrics = new HashMap<String, ScoreInterface>() {{
            this.put("score", new ScoreSum(InteractiveBoard.this.tiles()));
        }};
        int metricYStart = 15;
        for (final String id : metrics.keySet()) {
            g.drawString(id + ":" + metrics.get(id).value(), width + 15, metricYStart);
            metricYStart = metricYStart + 18;
        }
    }

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

    public void interact(PositionInterface position) {
        final TilesInterface tiles = this.tiles();
        if (tiles.has(position)) {
            final TileInterface clicked = tiles.get(position);
            this.tiles = this.gameplay.interact(clicked, tiles);
            this.repaint();
        }
    }

    private static class TileClickListener implements MouseListener {
        private final InteractiveBoard board;
        private final PositionInterface position;
        private final Point start;
        private final Point end;

        public TileClickListener(InteractiveBoard board, PositionInterface position, Point start, Point end) {
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

            if (this.start.getX() < x && this.start.getY() < y && this.end.getX() > x && this.end.getY() > y) {
                this.board.interact(this.position);
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
