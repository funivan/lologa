package org.funivan.lologa.tiles.filter

import org.funivan.lologa.tile.TileInterface
import org.funivan.lologa.tile.position.PositionInterface

class PositionFilter(private val position: PositionInterface) : TileFilterInterface {

    override fun apply(target: TileInterface): Boolean {
        return position == target.position()
    }
}
