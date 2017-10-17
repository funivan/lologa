package org.funivan.lologa.tile.Position

class Position(private val row: Int, private val col: Int) : PositionInterface {

    override fun row(): Int {
        return this.row
    }

    override fun col(): Int {
        return this.col
    }

    override fun toString(): String {
        return "Position{" + this.row + "x" + this.col + '}'
    }

    override fun equals(o: Any?): Boolean {
        var result = false
        if (this === o) {
            result = true
        } else if (o is PositionInterface) {
            result = o.row() == this.row() && o.col() == this.col()
        }
        return result
    }

    override fun hashCode(): Int {
        return 31 * this.row + this.col
    }

}
