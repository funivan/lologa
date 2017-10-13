package org.funivan.lologa.algo.modify;

import com.sun.istack.internal.NotNull;
import org.cactoos.list.ListOf;
import org.funivan.lologa.algo.find.TilesPerformer;
import org.funivan.lologa.tile.Position.Next;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.TilesInterface;

public class MoveDown implements TilesPerformer {

    private TilesInterface replace;

    public MoveDown(TilesInterface replace) {
        this.replace = replace;
    }

    @Override
    @NotNull
    public TilesInterface perform(TilesInterface tiles) {
        boolean replaced;
        TilesInterface replaceable = this.replace;
        do {
            replaced = false;
            for (final TileInterface tile : new ListOf<>(replaceable.all())) {
                final Next.Top top = new Next.Top(tile);
                if (tiles.has(top)) {
                    final TileInterface target = tiles.get(top);
                    if (!replaceable.has(target.position())) {
                        // swap items
                        TileInterface topTile = new Tile(tile.color(), tile.score(), target.position());
                        TileInterface bottomTile = new Tile(target.color(), target.score(), tile.position());
                        replaceable = replaceable.without(tile.position()).with(topTile);
                        tiles = tiles.with(topTile).with(bottomTile);
                        replaced = true;
                        break;
                    }
                }
            }
        } while (replaced);
        for (TileInterface tile : replaceable.all()) {
            tiles = tiles.without(tile.position());
        }
        return tiles;
    }
}
