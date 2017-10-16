package org.funivan.lologa.algo.ga.genome.population;

import org.cactoos.iterable.Cycled;
import org.cactoos.iterable.Limited;
import org.cactoos.iterable.Skipped;
import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.algo.ga.genome.population.crossing.CrossingInterface;
import org.funivan.lologa.algo.ga.genome.population.mutation.RandomizeInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class Population implements PopulationInterface {

    private final RandomizeInterface randomize;
    private final int size;
    private final CrossingInterface crossing;

    public Population(RandomizeInterface randomize, int size, CrossingInterface crossing) {
        this.randomize = randomize;
        this.size = size;
        this.crossing = crossing;
    }


    @Override
    public final Iterable<GenomeInterface> populate(final Iterable<GenomeInterface> genomes) {
        Iterator<GenomeInterface> fathers = new Cycled<>(new Limited<>(genomes, this.size / 4)).iterator();
        Iterator<GenomeInterface> mothers = new Cycled<>(new Skipped<>(genomes, this.size / 4)).iterator();
        ArrayList<GenomeInterface> result = new ArrayList<>();
        while (result.size() < this.size) {
            final GenomeInterface father = fathers.next();
            result.add(
                father.withData(
                    this.randomize.mix(
                        this.crossing.cross(father, mothers.next())
                    )
                )
            );
        }
        return result;
    }

}
