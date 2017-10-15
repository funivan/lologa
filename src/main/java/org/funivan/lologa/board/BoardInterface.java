package org.funivan.lologa.board;

import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tiles.TilesInterface;

public interface BoardInterface {


    TilesInterface tiles();

    BoardInterface interact(PositionInterface position);

}
