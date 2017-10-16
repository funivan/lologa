package org.funivan.lologa.algo.ga.genome.population.mutation;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;

public class RandomizeTest {
    @Test
    public void checkMix() {
        MatcherAssert.assertThat(
            "Expect randomize should change genome",
            new Randomize(0.01).mix(
                new HashMap<String, Double>() {{
                    this.put("max_score", 10.0);
                }}
            ).values(),
            Matchers.not(10.0)
        );
    }
}