package org.funivan.lologa.tile

import org.funivan.lologa.tile.position.PositionInterface
import org.funivan.lologa.tile.Score.ScoreInterface
import java.awt.Color

interface TileInterface {

    fun color(): Color

    fun score(): ScoreInterface

    fun position(): PositionInterface

    fun same(target: TileInterface): Boolean

}
