package org.funivan.lologa;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

public class Board extends JPanel {

    private final Iterable<Color> colors;

    public Board(Iterable<Color> colors) {
        this.colors = colors;
        this.setBorder(new LineBorder(Color.black));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final int cols = 5;
        final int rows = 5;
        final int spacer = 10;
        final int size = 50;

        Iterator<Color> iterator = this.colors.iterator();
        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                g.setColor(iterator.next());
                g.fillRect(
                    x * size + spacer * x,
                    y * size + spacer * y,
                    size,
                    size
                );
            }
        }
    }
}
