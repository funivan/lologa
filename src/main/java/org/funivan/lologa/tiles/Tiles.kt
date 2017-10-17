package org.funivan.lologa.tiles

import org.funivan.lologa.tile.Position.PositionInterface
import org.funivan.lologa.tile.TileInterface
import java.util.*

class Tiles @JvmOverloads constructor(private val tiles: HashMap<PositionInterface, TileInterface> = HashMap()) : TilesInterface {


    override fun get(position: PositionInterface): TileInterface {
        return this.tiles[position]
    }

    override fun has(position: PositionInterface): Boolean {
        return this.tiles.containsKey(position)
    }

    override fun without(position: PositionInterface): TilesInterface {
        val result = HashMap(this.tiles)
        result.remove(position)
        return Tiles(result)
    }

    override fun with(tile: TileInterface): TilesInterface {
        val result = HashMap(this.tiles)
        result.put(tile.position(), tile)
        return Tiles(result)
    }

    override fun all(): Iterable<TileInterface> {
        return this.tiles.values
    }

    override fun size(): Int {
        return this.tiles.size
    }
}
