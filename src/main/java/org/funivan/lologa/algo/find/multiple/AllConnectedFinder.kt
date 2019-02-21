package org.funivan.lologa.algo.find.multiple

import com.sun.istack.internal.NotNull
import org.funivan.lologa.algo.find.TilesAction
import org.funivan.lologa.tile.position.PositionInterface
import org.funivan.lologa.tile.TileInterface
import org.funivan.lologa.tiles.Tiles
import org.funivan.lologa.tiles.TilesInterface
import java.util.*

class AllConnectedFinder(private val start: TileInterface) : TilesAction {

    @NotNull
    override fun perform(tiles: TilesInterface): TilesInterface {
        var result = Tiles().with(this.start)

        val done = ArrayList<PositionInterface>()
        var touched: Boolean
        do {
            touched = false
            val found = ArrayList<TileInterface>()
            for (check in result.all()) {
                if (!done.contains(check.position())) {
                    touched = true
                    found.addAll(DirectConnectedFinder(check).perform(tiles).all())
                    done.add(check.position())
                }
            }
            for (tileInterface in found) {
                result = result.with(tileInterface)
            }
        } while (touched)
        return result
    }
}
