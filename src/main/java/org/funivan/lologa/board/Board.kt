package org.funivan.lologa.board

import org.funivan.lologa.algo.gameplay.GameplayInterface
import org.funivan.lologa.tile.Score.Score
import org.funivan.lologa.tile.Tile
import org.funivan.lologa.tile.position.Position
import org.funivan.lologa.tile.position.PositionInterface
import org.funivan.lologa.tiles.Tiles
import org.funivan.lologa.tiles.TilesInterface
import java.awt.Color

open class Board(
        private val gameplay: GameplayInterface,
        private val rows: Int,
        private val cols: Int,
        private val colors: Iterable<Color>,
        private var tiles: TilesInterface = Tiles()
) : BoardInterface {

    override fun tiles(): TilesInterface {
        val colors = this.colors.iterator()
        for (row in 0 until this.rows) {
            for (col in 0 until this.cols) {
                val position = Position(row, col)
                if (!this.tiles.has(position)) {
                    val color = colors.next()
                    println("next color: "+color)
                    this.tiles = this.tiles.with(Tile(color, Score(1), position))
                }
            }
        }
        return this.tiles
    }

    override fun interact(position: PositionInterface): BoardInterface {
        var tiles = this.tiles()
        if (tiles.has(position)) {
            val clicked = tiles.get(position)
            tiles = this.gameplay.interact(clicked, tiles)
        }
        return Board(this.gameplay, this.rows, this.cols, this.colors, tiles)
    }

    companion object {
        val GREEN = Color(100, 200, 100)
        val RED = Color(250, 50, 50)
        val BLUE = Color(1, 90, 250)
        val YELLOW = Color(255, 220, 40)
        val VIOLET = Color(255, 220, 40)
    }

}
