package org.funivan.lologa.algo.find.multiple

import org.funivan.lologa.algo.find.HandlerInterface
import org.funivan.lologa.tiles.Tiles
import org.funivan.lologa.tiles.TilesInterface

/**
 * Find tiles that could not be connected
 */
class LockedTilesFinder(private val minGroupLimit: Int) : HandlerInterface {

    override fun handle(tiles: TilesInterface): TilesInterface {
        var result: TilesInterface = Tiles()
        var done: TilesInterface = Tiles()
        for (tile in tiles.all()) {
            if (!done.has(tile.position())) {
                val same = AllConnectedFinder(tile).handle(tiles)
                for (alone in same.all()) {
                    done = done.with(alone)
                }
                if (same.size() < this.minGroupLimit) {
                    for (alone in same.all()) {
                        result = result.with(alone)
                    }
                }
            }
        }
        return result
    }
}
