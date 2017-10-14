package org.funivan.lologa.algo.ga.genome;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.HashMap;

public class ScoreCalculationTest {

    @Test
    public void calculate() {
        MatcherAssert.assertThat(
            "All col will be removed",
            new ScoreCalculation(
                new Genome(
                    new HashMap<String, Double>() {{
                        this.put("max_score", 0.1);
                        this.put("groups", 0.9);
                    }}
                )
            ).calculate(new HashMap<String, Double>() {{
                this.put("max_score", 0.5); // always positive
                this.put("groups", 12.0);
            }})
            ,
            Matchers.is(
                0.1 * 0.5 + 0.9 * 12.0
            )
        );
    }
}