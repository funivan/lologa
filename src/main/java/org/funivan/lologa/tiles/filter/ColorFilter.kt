package org.funivan.lologa.tiles.filter

import org.funivan.lologa.tile.TileInterface
import java.awt.Color

class ColorFilter(private val color: Color) : TileFilterInterface {

    override fun apply(tileInterface: TileInterface): Boolean? {
        return this.color == tileInterface.color()
    }
}
