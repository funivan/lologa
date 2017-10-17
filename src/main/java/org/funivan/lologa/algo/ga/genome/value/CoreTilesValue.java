package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.algo.find.HandlerInterface;
import org.funivan.lologa.algo.find.multiple.CoreTilesInGroupFinder;
import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.tiles.TilesInterface;

public class CoreTilesValue implements ValueInterface {
    private final HandlerInterface finder;

    public CoreTilesValue(GameplayInterface gameplay) {
        this.finder = new CoreTilesInGroupFinder(gameplay.minimum());
    }

    @Override
    public String type() {
        return "core_tiles";
    }

    @Override
    public Double value(TilesInterface original, TilesInterface tiles) {
        final double originOne = (double) original.size() / (double) this.finder.handle(original).size();
        final double newOne = (double) tiles.size() / (double) this.finder.handle(tiles).size();
        return originOne - newOne;
    }

}
