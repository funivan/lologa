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

}
