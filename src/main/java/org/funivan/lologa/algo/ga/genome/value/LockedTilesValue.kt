package org.funivan.lologa.algo.ga.genome.value

import org.funivan.lologa.algo.find.TilesAction
import org.funivan.lologa.algo.find.multiple.LockedTilesFinder
import org.funivan.lologa.algo.gameplay.GameplayInterface
import org.funivan.lologa.tiles.TilesInterface

class LockedTilesValue(gameplay: GameplayInterface) : ValueInterface {

    private val finder: TilesAction

    init {
        this.finder = LockedTilesFinder(gameplay.minimum())
    }

    override fun type(): String {
        return "locked"
    }

    override fun value(original: TilesInterface, tiles: TilesInterface): Double {
        val oldLocked = this.finder.perform(original).size().toDouble() / original.size().toDouble()
        val newLocked = this.finder.perform(tiles).size().toDouble() / tiles.size().toDouble()
        return oldLocked - newLocked
    }

}
