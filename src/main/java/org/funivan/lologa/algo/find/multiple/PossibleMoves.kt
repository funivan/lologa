package org.funivan.lologa.algo.find.multiple

import org.funivan.lologa.algo.find.TilesAction
import org.funivan.lologa.algo.find.one.MaxBottom
import org.funivan.lologa.tiles.Tiles
import org.funivan.lologa.tiles.TilesInterface

class PossibleMoves(private val num: Int) : TilesAction {

    override fun perform(tiles: TilesInterface): TilesInterface {
        var result: TilesInterface = Tiles()
        for (tile in tiles.all()) {
            val bottom = MaxBottom(tile).find(tiles)
            if (!result.has(bottom.position())) {
                val connected = AllConnectedFinder(bottom).perform(tiles).size()
                if (connected >= this.num) {
                    result = result.with(bottom)
                }
            }
        }
        return result
    }
}
