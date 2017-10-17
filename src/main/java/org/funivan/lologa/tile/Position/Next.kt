package org.funivan.lologa.tile.Position

import org.funivan.lologa.tile.TileInterface

open class Next(private val start: PositionInterface, private val rowStep: Int, private val colStep: Int) : PositionInterface {

    constructor(start: TileInterface, rowStep: Int, colStep: Int) : this(start.position(), rowStep, colStep) {}

    override fun row(): Int {
        return this.start.row() + this.rowStep
    }

    override fun col(): Int {
        return this.start.col() + this.colStep
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
        return 31 * this.row() + this.col()
    }


    class Top(start: TileInterface) : Next(start, -1, 0)

    class Right(start: TileInterface) : Next(start, 0, 1)

    class Bottom : Next {
        constructor(start: TileInterface) : super(start, 1, 0) {}
        constructor(start: PositionInterface) : super(start, 1, 0) {}
    }

    class Left(start: TileInterface) : Next(start, 0, -1)
}
