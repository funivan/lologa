package org.funivan.lologa.tiles;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.AtPosition;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;

import java.util.Iterator;

public class MovedDown implements TilesListInterface {
    private Iterable<TileInterface> tiles;
    private final Iterable<TileInterface> replaceable;

    public MovedDown(Iterable<TileInterface> tiles, Iterable<TileInterface> replaceable) {
        this.tiles = tiles;
        this.replaceable = replaceable;
    }

    @Override
    public Iterator<TileInterface> iterator() {
        TilesListInterface result = new TilesList(this.tiles);
        Iterable<TileInterface> moveItems = this.replaceable;
        boolean moved;
        boolean last = true;

        do {
            moved = false;
            Iterator<TileInterface> iter = result.iterator();
            while (iter.hasNext()) {
                TileInterface tile = iter.next();
                PositionInterface position = new Bottom(tile).position();
                TileInterface bottom = new AtPosition(position, result);
                TileInterface replaced = new AtPosition(position, moveItems);
                boolean skipTile = new AtPosition(tile.position(), moveItems).same(tile);
                if (!skipTile && bottom.same(replaced) && !bottom.same(Tile.DUMMY)) {
                    Tile current = new Tile(bottom.color(), bottom.score(), tile.position());
                    Tile bottomTile = new Tile(tile.color(), tile.score(), bottom.position());
                    result = new JoinedTilesList(result, new ListOf<>(current, bottomTile));
                    iter = result.iterator();
                    // Remove bottom tile + Add top tile
                    moveItems = new JoinedTilesList(
                        new SkippedTilesList(moveItems, new ListOf<>(replaced)),
                        current
                    );
                    moved = true;
                }
            }

        } while (moved);
        return new SkippedTilesList(result, moveItems).iterator();
    }

    public static void dump(String prefix, Iterable<TileInterface> tiles) {
        for (TileInterface tile : tiles) {
            System.out.println(prefix + ":" + tile);
        }
    }
}
