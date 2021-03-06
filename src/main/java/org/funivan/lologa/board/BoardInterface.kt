package org.funivan.lologa.board

import org.funivan.lologa.tile.position.PositionInterface
import org.funivan.lologa.tiles.TilesInterface

interface BoardInterface {

    fun tiles(): TilesInterface

    fun interact(position: PositionInterface): BoardInterface

}
