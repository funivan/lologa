package org.funivan.lologa.tiles.Filter

import org.funivan.lologa.tile.TileInterface
import java.awt.Color

class ColorFilter(private val color: Color) : TileFilterInterface {

    override fun apply(tileInterface: TileInterface): Boolean? {
        return this.color == tileInterface.color()
    }
}
