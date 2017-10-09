package org.funivan.lologa.tile.TileList;

import org.funivan.lologa.tile.TileInterface;

import java.io.IOException;

public interface PoolInterface {

    TileInterface get(int index) throws IOException;
}
