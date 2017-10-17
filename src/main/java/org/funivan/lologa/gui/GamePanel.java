package org.funivan.lologa.gui;

import org.funivan.lologa.board.BoardInterface;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Score.ScoreInterface;
import org.funivan.lologa.tile.Score.ScoreSum;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class GamePanel extends JPanel {

    private final HashMap<PositionInterface, MouseListener> mouseListener = new HashMap<>();
    private BoardInterface board;

    public GamePanel(BoardInterface board) {
        this.board = board;
        this.setBorder(new LineBorder(Color.black));
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final int size = 80;
        int width = size;
        final TilesInterface tiles = this.board.tiles();
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
            this.put("score", new ScoreSum(GamePanel.this.board.tiles()));
        }};
        int metricYStart = 15;
        for (final String id : metrics.keySet()) {
            g.drawString(id + ":" + metrics.get(id).value(), width + 15, metricYStart);
            metricYStart = metricYStart + 18;
        }
    }


    public void setBoard(BoardInterface board) {
        this.board = board;
        this.repaint();
    }


    private static class TileClickListener implements MouseListener {
        private final GamePanel panel;
        private final PositionInterface position;
        private final Point start;
        private final Point end;

        public TileClickListener(GamePanel panel, PositionInterface position, Point start, Point end) {
            this.panel = panel;
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
                this.panel.setBoard(
                    this.panel.board.interact(this.position)
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
