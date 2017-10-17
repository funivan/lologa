package org.funivan.lologa.algo.find.multiple

import com.sun.istack.internal.NotNull
import org.cactoos.list.ListOf
import org.funivan.lologa.algo.find.HandlerInterface
import org.funivan.lologa.tile.position.Next
import org.funivan.lologa.tile.TileInterface
import org.funivan.lologa.tiles.Tiles
import org.funivan.lologa.tiles.TilesInterface

class DirectConnectedFinder(private val start: TileInterface) : HandlerInterface {

    @NotNull
    override fun handle(tiles: TilesInterface): TilesInterface {
        val positions = ListOf(
                Next.Top(this.start),
                Next.Right(this.start),
                Next.Bottom(this.start),
                Next.Left(this.start)
        )
        var result: TilesInterface = Tiles()
        for (position in positions) {
            if (tiles.has(position)) {
                val next = tiles.get(position)
                if (next.color() == this.start.color()) {
                    result = result.with(next)
                }
            }
        }
        return result
    }
}
