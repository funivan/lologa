package org.funivan.lologa.tiles

import org.funivan.lologa.tile.position.PositionInterface
import org.funivan.lologa.tile.TileInterface
import java.util.*

class Tiles(private val tiles: HashMap<PositionInterface, TileInterface> = HashMap()) : TilesInterface {

    override fun get(position: PositionInterface): TileInterface {
        var tile = this.tiles.get(position);
        return tile ?: throw Exception("Invalid tile position " + position.toString())
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
