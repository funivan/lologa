package org.funivan.lologa.gui

import org.funivan.lologa.board.BoardInterface
import org.funivan.lologa.tile.position.PositionInterface
import org.funivan.lologa.tile.Score.ScoreInterface
import org.funivan.lologa.tile.Score.ScoreSum
import java.awt.Color
import java.awt.Graphics
import java.awt.Point
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.util.*
import javax.swing.JPanel
import javax.swing.border.LineBorder

class GamePanel(
        private var board: BoardInterface
) : JPanel() {

    private val mouseListener = HashMap<PositionInterface, MouseListener>()

    init {
        this.border = LineBorder(Color.black)
    }


    override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        val size = 80
        var width = size
        val tiles = this.board.tiles()
        for (tile in tiles.all()) {
            val position = tile.position()
            val x = position.col() * size
            val y = position.row() * size
            if (x + size > width) {
                width = x + size
            }
            if (!this.mouseListener.containsKey(position)) {
                val listener = TileClickListener(this, position, Point(x, y), Point(x + size, y + size))
                this.addMouseListener(listener)
                this.mouseListener.put(position, listener)
            }
            g.color = tile.color()
            g.fillRect(x, y, size, size)
            g.color = Color.BLACK
            g.drawRect(x, y, size, size)
            g.color = Color(215, 215, 215)
            g.drawString("" + tile.score().value().toString(), x + size / 2, y + size / 2)
        }

        g.color = Color.BLACK
        val metrics = hashMapOf<String, ScoreInterface>(
                "score" to ScoreSum(this@GamePanel.board.tiles())
        )
        var metricYStart = 15
        for ((name, score) in metrics) {
            g.drawString(name + ":" + score.value(), width + 15, metricYStart)
            metricYStart = metricYStart + 18
        }
    }


    fun setBoard(board: BoardInterface) {
        this.board = board
        this.repaint()
    }


    private class TileClickListener(private val panel: GamePanel, private val position: PositionInterface, private val start: Point, private val end: Point) : MouseListener {

        override fun mouseClicked(mouseEvent: MouseEvent) {

        }

        override fun mousePressed(mouseEvent: MouseEvent) {

        }

        override fun mouseReleased(mouseEvent: MouseEvent) {
            val x = mouseEvent.point.x
            val y = mouseEvent.point.y

            if (this.start.getX() < x && this.start.getY() < y && this.end.getX() > x && this.end.getY() > y) {
                this.panel.setBoard(
                        this.panel.board.interact(this.position)
                )
            }
        }

        override fun mouseEntered(mouseEvent: MouseEvent) {

        }

        override fun mouseExited(mouseEvent: MouseEvent) {

        }
    }
}
