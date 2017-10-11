package org.funivan.lologa.tiles;

import org.funivan.lologa.tile.Next;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;

import java.util.Iterator;

public class MovedDown implements TilesInterface {
    private Iterable<TileInterface> tiles;
    private int row;

    public MovedDown(Iterable<TileInterface> tiles, int row) {
        this.tiles = tiles;
        this.row = row;
    }

    @Override
    public Iterator<TileInterface> iterator() {
        TilesInterface result = new Tiles(this.tiles);
        boolean moved;
        do {
            moved = false;
            for (TileInterface tile : result) {
                Next bottom = new Next(new Bottom(tile), result);
                if (bottom.same(Tile.DUMMY) && bottom.position().row() < this.row) {
                    moved = true;
                    result = new SkippedTiles(
                        new JoinedTiles(
                            result,
                            new Tile(tile.color(), tile.score(), bottom.position())
                        ),
                        new Tiles(tile)
                    );
                }
            }
        } while (moved);
        return result.iterator();
    }

}
