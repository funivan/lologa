package org.funivan.lologa;

import org.cactoos.iterable.*;
import org.cactoos.list.ListOf;
import org.funivan.lologa.algo.ga.genome.Genome;
import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.algo.ga.genome.Genomes;
import org.funivan.lologa.algo.ga.genome.metric.Metrics;
import org.funivan.lologa.algo.ga.genome.metric.MetricsInterface;
import org.funivan.lologa.algo.ga.genome.population.Population;
import org.funivan.lologa.algo.ga.genome.population.crossing.HalfCross;
import org.funivan.lologa.algo.ga.genome.population.mutation.Randomize;
import org.funivan.lologa.algo.ga.genome.value.AverageScoreValue;
import org.funivan.lologa.algo.ga.genome.value.LockedValue;
import org.funivan.lologa.algo.ga.genome.value.MaxScoreValue;
import org.funivan.lologa.algo.ga.genome.value.RemovedTilesValue;
import org.funivan.lologa.algo.ga.player.Player;
import org.funivan.lologa.algo.ga.player.PlayerInterface;
import org.funivan.lologa.algo.ga.player.fitness.AverageScoreFitness;
import org.funivan.lologa.algo.ga.player.fitness.FitnessInterface;
import org.funivan.lologa.algo.ga.player.fitness.MaxScoreFitness;
import org.funivan.lologa.algo.gameplay.ClassicGamePlay;
import org.funivan.lologa.board.BoardInterface;
import org.funivan.lologa.board.boards.Middle5To5Board;

import java.util.HashMap;

public class Cli {

    public static void main(String[] args) {
        final ClassicGamePlay gameplay = new ClassicGamePlay();
        final BoardInterface board = new Middle5To5Board(gameplay);
        final MetricsInterface metrics = new Metrics(new ListOf<>(
            new AverageScoreValue(),
            new MaxScoreValue(),
            new LockedValue(gameplay),
            new RemovedTilesValue()
        ));
        final GenomeInterface zeroGenome = new Genome(
            new HashMap<String, Double>() {{
                this.put(new AverageScoreValue().type(), 0.1);
                this.put(new MaxScoreValue().type(), 0.1);
                this.put(new LockedValue(gameplay).type(), 0.1);
                this.put(new RemovedTilesValue().type(), 0.1);
            }},
            gameplay,
            metrics
        );

        final int playersNum = 20;
        final int maxGenerations = 500;
        final Population initialPopulation = new Population(new Randomize(0.04), playersNum, new HalfCross());
        final Population nextPopulation = new Population(new Randomize(0.003), playersNum, new HalfCross());
        final FitnessInterface fitness = new AverageScoreFitness();

        Iterable<GenomeInterface> genomes = initialPopulation.populate(new Repeated<>(zeroGenome, playersNum));
        for (int g = 1; g < maxGenerations; g++) {
            Iterable<PlayerInterface> generation = new IterableOf<>();
            for (GenomeInterface genome : genomes) {
                final PlayerInterface max = new Player(genome, board, fitness);
                generation = new Joined<>(generation, new IterableOf<>(max));
            }

            final Sorted<PlayerInterface> players = new Sorted<>(generation);
            System.out.println("Generation " + g + ". Top results");
            for (PlayerInterface generationPlayer : new Limited<>(players, playersNum / 2)) {
                System.out.println(generationPlayer.toString() + " P " + generationPlayer.genome().data());
            }
            // born new generation
            genomes = nextPopulation.populate(new Genomes(players));
        }

    }
}
