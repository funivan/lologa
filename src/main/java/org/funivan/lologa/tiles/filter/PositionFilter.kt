package org.funivan.lologa.tiles.filter

import org.funivan.lologa.tile.Position.PositionInterface
import org.funivan.lologa.tile.TileInterface

class PositionFilter(
        private val position: PositionInterface, private val expect: TileFilterInterface.EXPECT = TileFilterInterface.EXPECT.Positive
) : TileFilterInterface {

    override fun apply(target: TileInterface): Boolean {
        val expectResult = this.expect == TileFilterInterface.EXPECT.Positive
        val result = this.position == target.position()
        return expectResult == result
    }
}
