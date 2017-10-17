package org.funivan.lologa.algo.ga.genome.value

import org.funivan.lologa.algo.find.HandlerInterface
import org.funivan.lologa.algo.find.multiple.LockedTilesFinder
import org.funivan.lologa.algo.gameplay.GameplayInterface
import org.funivan.lologa.tiles.TilesInterface

class LockedTilesValue(gameplay: GameplayInterface) : ValueInterface {

    private val finder: HandlerInterface

    init {
        this.finder = LockedTilesFinder(gameplay.minimum())
    }

    override fun type(): String {
        return "locked"
    }

    override fun value(original: TilesInterface, tiles: TilesInterface): Double? {
        val oldLocked = this.finder.handle(original).size().toDouble() / original.size().toDouble()
        val newLocked = this.finder.handle(tiles).size().toDouble() / tiles.size().toDouble()
        return oldLocked - newLocked
    }

}
