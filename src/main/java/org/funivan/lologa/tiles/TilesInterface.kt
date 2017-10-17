package org.funivan.lologa.tiles

import org.funivan.lologa.tile.Position.PositionInterface
import org.funivan.lologa.tile.TileInterface

interface TilesInterface {

    operator fun get(position: PositionInterface): TileInterface

    fun has(position: PositionInterface): Boolean

    fun without(position: PositionInterface): TilesInterface

    fun with(tile: TileInterface): TilesInterface

    fun all(): Iterable<TileInterface>

    fun size(): Int


}
