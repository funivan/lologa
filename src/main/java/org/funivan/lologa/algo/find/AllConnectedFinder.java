package org.funivan.lologa.algo.find;

import com.sun.istack.internal.NotNull;
import org.cactoos.iterable.Joined;
import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Tiles;
import org.funivan.lologa.tiles.TilesInterface;

import java.util.ArrayList;
import java.util.List;

public class AllConnectedFinder implements TilesAction {
    private final TileInterface start;

    public AllConnectedFinder(TileInterface start) {
        this.start = start;
    }

    @Override
    @NotNull
    public TilesInterface perform(TilesInterface tiles) {
        TilesInterface result = new Tiles().with(this.start);

        List<PositionInterface> done = new ArrayList<>();
        boolean touched;
        do {
            touched = false;
            Iterable<TileInterface> found = new ArrayList<>();
            for (TileInterface check : result.all()) {
                if (!done.contains(check.position())) {
                    touched = true;
                    found = new Joined<>(
                        found,
                        new DirectConnectedFinder(check).perform(tiles).all()
                    );
                    done.add(check.position());
                }
            }
            for (TileInterface tileInterface : found) {
                result = result.with(tileInterface);
            }
        } while (touched);
        return result;
    }
}
