package org.funivan.lologa.tiles;

import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.AtPosition;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tile.Visitor.Navigation.Direction.Bottom;

import java.util.Iterator;

public class MovedDown implements TilesInterface {
    private Iterable<TileInterface> tiles;
    private final Iterable<TileInterface> replaceable;

    public MovedDown(Iterable<TileInterface> tiles, Iterable<TileInterface> replaceable) {
        this.tiles = tiles;
        this.replaceable = replaceable;
    }

    @Override
    public Iterator<TileInterface> iterator() {
        TilesInterface result = new Tiles(this.tiles);
        Iterable<TileInterface> moveItems = this.replaceable;
        boolean moved;
        do {
            moved = false;
            for (TileInterface tile : result) {
                PositionInterface position = new Bottom(tile).position();
                TileInterface bottom = new AtPosition(position, result);
                TileInterface replaced = new AtPosition(position, moveItems);
                if (bottom.same(replaced) && !bottom.same(Tile.DUMMY)) {
                    System.out.println("Should be swapped: " + tile.position() + " to " + position);
                    result = new JoinedTiles(
                        result,
                        new ListOf<>(
                            new Tile(bottom.color(), bottom.score(), tile.position()),
                            new Tile(tile.color(), tile.score(), bottom.position())
                        )
                    );
                    // Remove bottom tile + Add top tile
                    moveItems = new JoinedTiles(
                        new SkippedTiles(moveItems, new ListOf<>(bottom)),
                        tile
                    );
                    moved = true;
                }
            }
        } while (moved);
        return new SkippedTiles(result, moveItems).iterator();
    }

    public static void dump(String prefix, Iterable<TileInterface> tiles) {
        for (TileInterface tile : tiles) {
            System.out.println(prefix + ":" + tile.position());
        }
    }
}
