package org.funivan.lologa.algo.ga.genome;

import java.util.HashMap;

public class Genome implements GenomeInterface {
    private final HashMap<String, Float> values;

    public Genome(HashMap<String, Float> values) {
        this.values = values;
    }

    public HashMap<String, Float> values() {
        return this.values;
    }

}
