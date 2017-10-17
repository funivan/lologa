package org.funivan.lologa;

import org.cactoos.iterable.Repeated;
import org.cactoos.iterable.Sorted;
import org.cactoos.list.ListOf;
import org.funivan.lologa.algo.ga.genome.Genome;
import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.algo.ga.genome.Genomes;
import org.funivan.lologa.algo.ga.genome.metric.Metrics;
import org.funivan.lologa.algo.ga.genome.metric.MetricsInterface;
import org.funivan.lologa.algo.ga.genome.play.LoggablePlayGeneration;
import org.funivan.lologa.algo.ga.genome.play.PlayGeneration;
import org.funivan.lologa.algo.ga.genome.play.PlayGenerationInterface;
import org.funivan.lologa.algo.ga.genome.population.Population;
import org.funivan.lologa.algo.ga.genome.population.crossing.RandomCross;
import org.funivan.lologa.algo.ga.genome.population.mutation.Initialization;
import org.funivan.lologa.algo.ga.genome.population.mutation.Randomize;
import org.funivan.lologa.algo.ga.genome.value.*;
import org.funivan.lologa.algo.ga.player.PlayerInterface;
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
            new PossibleMovesValue(gameplay),
            new RemovedTilesValue()
        ));
        final GenomeInterface zeroGenome = new Genome(
            new HashMap<String, Double>() {{
                this.put(new AverageScoreValue().type(), 0.0);
                this.put(new MaxScoreValue().type(), 0.0);
                this.put(new LockedValue(gameplay).type(), 0.0);
                this.put(new PossibleMovesValue(gameplay).type(), 0.0);
                this.put(new RemovedTilesValue().type(), 0.0);
            }},
            gameplay,
            metrics
        );

        final int playersNum = 50;
        final int maxGenerations = 500;
        final Population initialPopulation = new Population(new Initialization(), playersNum, new RandomCross());
        final Population nextPopulation = new Population(new Randomize(0.05, 0.2), playersNum, new RandomCross());

        final PlayGenerationInterface play = new LoggablePlayGeneration(0.10, new PlayGeneration(board));
        Iterable<GenomeInterface> genomes = initialPopulation.populate(new Repeated<>(zeroGenome, playersNum));
        for (int g = 1; g < maxGenerations; g++) {
            final Iterable<PlayerInterface> generation = play.play(genomes);
            genomes = nextPopulation.populate(
                new Genomes(
                    new Sorted<>(generation)
                )
            );
        }

    }
}
