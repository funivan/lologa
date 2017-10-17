package org.funivan.lologa.algo.find.one

import org.funivan.lologa.tile.TileInterface
import org.funivan.lologa.tiles.TilesInterface

interface TileFinder {

    fun find(tiles: TilesInterface): TileInterface

}
