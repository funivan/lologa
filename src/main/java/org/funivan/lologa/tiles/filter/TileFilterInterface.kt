package org.funivan.lologa.tiles.filter

import org.cactoos.Func
import org.funivan.lologa.tile.TileInterface

interface TileFilterInterface : Func<TileInterface, Boolean> {
    enum class EXPECT {
        Positive, Negative
    }
}
