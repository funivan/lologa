package org.funivan.lologa.tiles.Filter;

import org.cactoos.Func;
import org.funivan.lologa.tile.TileInterface;

import java.awt.*;

public class ColorFilter implements Func<TileInterface, Boolean> {
    private Color color;

    public ColorFilter(Color color) {
        this.color = color;
    }

    @Override
    public Boolean apply(TileInterface tileInterface) throws Exception {
        return this.color.equals(tileInterface.color());
    }
}
