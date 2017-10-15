package org.funivan.lologa.algo.ga.genome;

import java.util.HashMap;

public class Genome implements GenomeInterface {
    private final HashMap<String, Double> values;

    public Genome(HashMap<String, Double> values) {
        this.values = values;
    }

    public HashMap<String, Double> data() {
        return this.values;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("Genome");
        r.append("{");
        for (final String id : this.values.keySet()) {
            r.append(id).append(" = ").append(this.values.get(id)).append(";");
        }
        r.append("}");
        return r.toString();
    }
}
