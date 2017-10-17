package org.funivan.lologa.algo.ga.genome.play;

import org.cactoos.iterable.LengthOf;
import org.cactoos.iterable.Limited;
import org.cactoos.iterable.Sorted;
import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.algo.ga.player.PlayerInterface;

public class LoggablePlayGeneration implements PlayGenerationInterface {
    private final double slice;
    private final PlayGenerationInterface origin;
    private int index = 0;


    public LoggablePlayGeneration(double slice, PlayGenerationInterface origin) {
        this.slice = slice;
        this.origin = origin;
    }

    @Override
    public Iterable<PlayerInterface> play(Iterable<GenomeInterface> genomes) {
        Iterable<PlayerInterface> generation = this.origin.play(genomes);
        System.out.println("Generation " + this.index + " Top " + (int) (this.slice * 100) + "% results");
        this.index++;
        final Sorted<PlayerInterface> players = new Sorted<>(
            new Limited<>(generation, (int) (new LengthOf(generation).value() * this.slice))
        );
        for (final PlayerInterface generationPlayer : players) {
            System.out.println(generationPlayer.toString() + " P " + generationPlayer.genome().data());
        }
        return generation;
    }

}
