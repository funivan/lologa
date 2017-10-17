package org.funivan.lologa.algo.modify

import com.sun.istack.internal.NotNull
import org.cactoos.list.ListOf
import org.funivan.lologa.algo.find.HandlerInterface
import org.funivan.lologa.tile.position.Next
import org.funivan.lologa.tile.Tile
import org.funivan.lologa.tile.TileInterface
import org.funivan.lologa.tiles.TilesInterface

class MoveDown(private val replace: TilesInterface) : HandlerInterface {

    @NotNull
    public override fun handle(tiles: TilesInterface): TilesInterface {
        var tiles = tiles
        var replaced: Boolean
        var replaceable = this.replace
        do {
            replaced = false
            for (tile in ListOf<TileInterface>(replaceable.all())) {
                val top = Next.Top(tile)
                if (tiles.has(top)) {
                    val target = tiles.get(top)
                    if (!replaceable.has(target.position())) {
                        // swap items
                        val topTile = Tile(tile.color(), tile.score(), target.position())
                        val bottomTile = Tile(target.color(), target.score(), tile.position())
                        replaceable = replaceable.without(tile.position()).with(topTile)
                        tiles = tiles.with(topTile).with(bottomTile)
                        replaced = true
                        break
                    }
                }
            }
        } while (replaced)
        for (tile in replaceable.all()) {
            tiles = tiles.without(tile.position())
        }
        return tiles
    }
}
