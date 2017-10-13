package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

import java.util.HashMap;

public class Tiles implements TilesInterface {
    final HashMap<PositionInterface, TileInterface> tiles;

    public Tiles(HashMap<PositionInterface, TileInterface> tiles) {
        this.tiles = tiles;
    }

    public Tiles() {
        this(new HashMap<>());
    }


    @Override
    public TileInterface get(PositionInterface position) {
        return this.tiles.get(position);
    }

    @Override
    public boolean has(PositionInterface position) {
        return this.tiles.containsKey(position);
    }

    @Override
    public TilesInterface without(PositionInterface position) {
        HashMap<PositionInterface, TileInterface> result = this.tiles;
        result.remove(position);
        return new Tiles(result);
    }

    @Override
    public TilesInterface with(TileInterface tile) {
        HashMap<PositionInterface, TileInterface> result = this.tiles;
        result.put(tile.position(), tile);
        return new Tiles(result);
    }

    @Override
    public Iterable<TileInterface> all() {
        return this.tiles.values();
    }

}
