package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.algo.find.HandlerInterface;
import org.funivan.lologa.algo.find.multiple.LockedTilesFinder;
import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.tiles.TilesInterface;

public class LockedValue implements ValueInterface {

    private final HandlerInterface finder;

    public LockedValue(GameplayInterface gameplay) {
        this.finder = new LockedTilesFinder(gameplay.minimum());
    }

    @Override
    public String type() {
        return "locked";
    }

    @Override
    public Double value(TilesInterface original, TilesInterface tiles) {
        final double oldLocked = (double) this.finder.handle(original).size() / (double) original.size();
        final double newLocked = (double) this.finder.handle(tiles).size() / (double) original.size();
        return oldLocked - newLocked;
    }

}
