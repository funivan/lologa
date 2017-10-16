package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.tiles.TilesInterface;

public class LoggableValueInterface implements ValueInterface {
    private final boolean show;
    private final ValueInterface origin;

    public LoggableValueInterface(boolean show, ValueInterface origin) {
        this.show = show;
        this.origin = origin;
    }

    @Override
    public String type() {
        return this.origin.type();
    }

    @Override
    public Double value(TilesInterface original, TilesInterface tiles) {
        Double v = this.origin.value(original, tiles);
        if (this.show) {
            System.out.println(this.getClass() + " = " + v);
        }
        return v;
    }
}
