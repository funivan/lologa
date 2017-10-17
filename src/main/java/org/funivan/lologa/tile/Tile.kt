package org.funivan.lologa.tile

import org.funivan.lologa.tile.Position.Position
import org.funivan.lologa.tile.Position.PositionInterface
import org.funivan.lologa.tile.Score.Score
import org.funivan.lologa.tile.Score.ScoreInterface
import java.awt.Color
import java.util.*

class Tile(private val color: Color, private val score: ScoreInterface, private val position: PositionInterface) : TileInterface {

    constructor(color: Color, position: PositionInterface) : this(color, Score(1), position) {}

    constructor(score: Score, position: PositionInterface) : this(Color.WHITE, score, position) {}

    override fun color(): Color {
        return this.color
    }

    override fun score(): ScoreInterface {
        return this.score
    }


    override fun position(): PositionInterface {
        return this.position
    }

    override fun equals(o: Any?): Boolean {
        var result = false
        if (this === o) {
            result = true
        } else if (o is TileInterface) {
            val target = o as TileInterface?
            result = target!!.color() == this.color() && target.position() == this.position()
        }
        return result
    }

    override fun hashCode(): Int {
        return Objects.hash(this.color, this.score, this.position)
    }

    override fun same(target: TileInterface): Boolean {
        return (target.score().value() == this.score().value()
                &&
                target.color() == this.color()
                &&
                target.position() == this.position())
    }

    override fun toString(): String {
        return ("Tile: " +
                "{Color{r" + this.color.red + ",g" + this.color.green + ",b" + this.color.blue + "}}"
                + "," + this.score + ""
                + "," + this.position)
    }

    companion object {

        val DUMMY: TileInterface = Tile(Color(0, 0, 0), Score(-1), Position(-1, -1))
    }
}
