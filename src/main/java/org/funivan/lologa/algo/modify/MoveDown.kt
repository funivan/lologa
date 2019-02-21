package org.funivan.lologa.algo.modify

import com.sun.istack.internal.NotNull
import org.cactoos.list.ListOf
import org.funivan.lologa.algo.find.TilesAction
import org.funivan.lologa.tile.position.Next
import org.funivan.lologa.tile.Tile
import org.funivan.lologa.tile.TileInterface
import org.funivan.lologa.tiles.TilesInterface

class MoveDown(private val replace: TilesInterface) : TilesAction {

    @NotNull
    override fun perform(tiles: TilesInterface): TilesInterface {
        var result = tiles
        var replaced: Boolean
        var replaceable = this.replace
        do {
            replaced = false
            for (tile in ListOf<TileInterface>(replaceable.all())) {
                val top = Next.Top(tile)
                if (result.has(top)) {
                    val target = result.get(top)
                    if (!replaceable.has(target.position())) {
                        // swap items
                        val topTile = Tile(tile.color(), tile.score(), target.position())
                        val bottomTile = Tile(target.color(), target.score(), tile.position())
                        replaceable = replaceable.without(tile.position()).with(topTile)
                        result = result.with(topTile).with(bottomTile)
                        replaced = true
                        break
                    }
                }
            }
        } while (replaced)
        for (tile in replaceable.all()) {
            result = result.without(tile.position())
        }
        return result
    }
}
