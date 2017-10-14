package org.funivan.lologa.algo.ga.genome.metric;

import org.cactoos.list.ListOf;
import org.funivan.lologa.algo.ga.genome.value.LockedValue;
import org.funivan.lologa.algo.ga.genome.value.MaxScoreValue;
import org.funivan.lologa.algo.ga.genome.value.PossibleMovesValue;
import org.funivan.lologa.algo.ga.genome.value.ValueInterface;
import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.tiles.TilesInterface;

import java.util.HashMap;

public class MetricCollector implements MetricCollectorInterface {
    private final ListOf<ValueInterface> values;

    public MetricCollector(GameplayInterface gameplay) {
        this.values = new ListOf<>(
            new MaxScoreValue(),
            new PossibleMovesValue(gameplay),
            new LockedValue(gameplay)
        );
    }

    @Override
    public HashMap<String, Double> collect(TilesInterface tiles) {
        HashMap<String, Double> result = new HashMap<>();
        for (final ValueInterface value : this.values) {
            result.put(value.type(), value.value(tiles));
        }
        return result;
    }
}
