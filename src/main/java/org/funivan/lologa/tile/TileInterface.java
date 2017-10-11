package org.funivan.lologa.tile;

import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Score.ScoreInterface;

import java.awt.*;

public interface TileInterface {

    Color color();

    ScoreInterface score();

    PositionInterface position();

    boolean same(TileInterface target);

}
