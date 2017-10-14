package org.funivan.lologa.algo.ga.genome.metric;

import org.funivan.lologa.algo.ga.genome.value.ValueInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.util.HashMap;

public class Metrics implements MetricsInterface {
    private final Iterable<ValueInterface> values;

    public Metrics(Iterable<ValueInterface> values) {
        this.values = values;
    }

    @Override
    public HashMap<String, Double> collect(TilesInterface original, TilesInterface tiles) {
        HashMap<String, Double> result = new HashMap<>();
        for (final ValueInterface value : this.values) {
            result.put(value.type(), value.value(original, tiles));
        }
        return result;
    }
}
