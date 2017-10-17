package org.funivan.lologa.algo.gameplay

import org.funivan.lologa.tile.TileInterface
import org.funivan.lologa.tiles.TilesInterface

interface GameplayInterface {
    fun minimum(): Int

    fun interact(tile: TileInterface, tiles: TilesInterface): TilesInterface
}
