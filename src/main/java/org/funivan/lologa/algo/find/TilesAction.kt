package org.funivan.lologa.algo.find

import com.sun.istack.internal.NotNull
import org.funivan.lologa.tiles.TilesInterface

interface TilesAction {
    @NotNull
    fun perform(tiles: TilesInterface): TilesInterface
}
