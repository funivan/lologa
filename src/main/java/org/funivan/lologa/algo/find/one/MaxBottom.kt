package org.funivan.lologa.algo.find.one

import com.sun.istack.internal.NotNull
import org.funivan.lologa.tile.Position.Next
import org.funivan.lologa.tile.TileInterface
import org.funivan.lologa.tiles.TilesInterface

class MaxBottom(private val start: TileInterface) : TileFinder {

    @NotNull
    override fun find(tiles: TilesInterface): TileInterface {
        var position = this.start.position()
        while (true) {
            val next = Next.Bottom(position)
            if (tiles.has(next) && tiles.get(next).color() == this.start.color()) {
                position = next
            } else {
                break
            }
        }
        return tiles.get(position)
    }
}
