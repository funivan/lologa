package org.funivan.lologa.tiles.Filter;

import org.cactoos.Func;
import org.funivan.lologa.tile.TileInterface;

public interface TileFilterInterface extends Func<TileInterface, Boolean> {
    enum EXPECT {
        Same, Different
    }
}
