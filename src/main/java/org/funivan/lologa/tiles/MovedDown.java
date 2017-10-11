package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.AtPosition;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Position.TilePositions;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;

import java.util.Iterator;

public class MovedDown implements TilesInterface {
    private Iterable<TileInterface> tiles;

    public MovedDown(Iterable<TileInterface> tiles) {
        this.tiles = tiles;

    }

    @Override
    public Iterator<TileInterface> iterator() {
        TilesInterface result = new Tiles(this.tiles);
        int maxRow = 0;
        for (PositionInterface pos : new TilePositions(result)) {
            maxRow = pos.row() > maxRow ? pos.row() : maxRow;
        }
        boolean moved;
        do {
            moved = false;
            for (TileInterface tile : result) {
                PositionInterface current = new Bottom(tile).position();
                TileInterface bottom = new AtPosition(current, result);
                if (bottom.same(Tile.DUMMY) && current.row() <= maxRow) {
                    moved = true;
                    result = new SkippedTiles(
                        new JoinedTiles(
                            result,
                            new Tile(tile.color(), tile.score(), current)
                        ),
                        new Tiles(tile)
                    );
                }
            }
        } while (moved);
        return result.iterator();
    }

}
