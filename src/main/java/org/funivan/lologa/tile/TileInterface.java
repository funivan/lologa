package org.funivan.lologa.tile;

import org.funivan.lologa.tile.Position.PositionInterface;

import java.awt.*;

public interface TileInterface {

    Color color();

    int score();

    int index();

    PositionInterface position();

    boolean same(TileInterface target);

}
