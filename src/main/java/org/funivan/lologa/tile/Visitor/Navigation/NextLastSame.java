package org.funivan.lologa.tile.Visitor.Navigation;

import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.TilesPool.TilesPoolInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.DirectionInterface;
import org.funivan.lologa.tiles.TilesInterface;

public class NextLastSame implements NavigationInterface {
    private DirectionInterface direction;

    public NextLastSame(DirectionInterface direction) {
        this.direction = direction;
    }

    @Override
    public TileInterface navigate(TileInterface start, TilesPoolInterface tilesPool) {
        int next = start.index();
        TileInterface result = start;
        final TilesInterface tiles = tilesPool.tiles();
        while (tiles.get(next).color().equals(start.color())) {
            result = tiles.get(next);
            next = this.direction.index(next, tilesPool);
        }
        return result;
    }


}
