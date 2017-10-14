package org.funivan.lologa;

import org.funivan.lologa.algo.ga.genome.metric.MetricCollector;
import org.funivan.lologa.algo.gameplay.ClassicGamePlay;
import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Score.Score;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Iterator;

public class Board extends JPanel {

    public static final int CONNECTED_LIMIT = 3;
    private final GameplayInterface gameplay;
    private TilesInterface tiles;
    private final int rows;
    private final int cols;
    private final Iterable<Color> colors;
    private final HashMap<PositionInterface, MouseListener> mouseListener = new HashMap<>();

    public Board(TilesInterface tiles, int rows, int cols, Iterable<Color> colors) {
        this.tiles = tiles;
        this.rows = rows;
        this.cols = cols;
        this.colors = colors;
        this.gameplay = new ClassicGamePlay();
        this.setBorder(new LineBorder(Color.black));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final int cols = this.cols;
        final int rows = this.rows;
        final int size = 80;
        final int len = cols * rows;
        final Iterator<Color> iterator = this.colors.iterator();
        int row = 0;
        for (int index = 0; index < len; index++) {
            int col = index % rows;
            int x = col * size;
            row = row + ((index > 0 && index % cols == 0) ? 1 : 0);
            int y = row * size;
            final Position position = new Position(row, col);

            if (!this.mouseListener.containsKey(position)) {
                final TileClickListener listener = new TileClickListener(this, position, new Point(x, y), new Point(x + size, y + size));
                this.addMouseListener(listener);
                this.mouseListener.put(position, listener);
            }
            TileInterface tile;
            if (!this.tiles.has(position)) {
                tile = new Tile(iterator.next(), new Score(1), position);
                this.tiles = this.tiles.with(tile);
            } else {
                tile = this.tiles.get(position);
            }
            g.setColor(tile.color());
            g.fillRect(x, y, size, size);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, size, size);
            g.setColor(new Color(215, 215, 215));
            g.drawString("" + String.valueOf(tile.score().value()), x + size / 2, y + size / 2);
        }
        g.setColor(Color.BLACK);

        HashMap<String, Double> metric = new MetricCollector(this.gameplay).collect(this.tiles);
        int metricYStart = 15;
        for (String id : metric.keySet()) {
            g.drawString(id + ":" + metric.get(id), 600, metricYStart);
            metricYStart = metricYStart + 18;
        }
        //g.drawString("Groups : " + new CoreTilesInGroupFinder(this.CONNECTED_LIMIT).handle(this.tiles).size(), 700, 70);
        //g.drawString("Single : " + new SingleTilesFinder().handle(this.tiles).size(), 700, 90);
    }

    public void interact(PositionInterface position) {
        if (this.tiles.has(position)) {
            final TileInterface clicked = this.tiles.get(position);
            this.paint(
                this.gameplay.interact(clicked, this.tiles)
            );
        }
    }

    public void paint(TilesInterface tiles) {
        this.tiles = tiles;
        this.repaint();
    }

    private static class TileClickListener implements MouseListener {
        private final Board board;
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
