package org.funivan.lologa.algo.gameplay

import org.cactoos.scalar.LengthOf
import org.funivan.lologa.algo.find.multiple.AllConnectedFinder
import org.funivan.lologa.algo.find.one.MaxBottom
import org.funivan.lologa.algo.modify.MoveDown
import org.funivan.lologa.tile.Score.ScoreSum
import org.funivan.lologa.tile.Tile
import org.funivan.lologa.tile.TileInterface
import org.funivan.lologa.tiles.TilesInterface

class ClassicGamePlay : GameplayInterface {


    override fun minimum(): Int {
        return 3
    }

    override fun interact(tile: TileInterface, tiles: TilesInterface): TilesInterface {
        var result = tiles
        var connected = AllConnectedFinder(tile).perform(result)
        if (LengthOf(connected.all()).value() >= this.minimum()) {
            val score = ScoreSum(connected.all())
            val bottom = MaxBottom(tile).find(result)
            connected = connected.without(bottom.position())
            result = MoveDown(connected).perform(result)
            result = result.with(Tile(bottom.color(), score, bottom.position()))
        }
        return result
    }
}
