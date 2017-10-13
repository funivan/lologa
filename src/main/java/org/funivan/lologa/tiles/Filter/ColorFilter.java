package org.funivan.lologa.tiles.Filter;

import org.funivan.lologa.tile.TileInterface;

import java.awt.*;

public class ColorFilter implements TileFilterInterface{
    private Color color;

    public ColorFilter(Color color) {
        this.color = color;
    }

    @Override
    public Boolean apply(TileInterface tileInterface) {
        return this.color.equals(tileInterface.color());
    }
}
