package org.funivan.lologa;

import org.cactoos.iterable.*;
import org.cactoos.list.ListOf;
import org.funivan.lologa.algo.ga.genome.metric.Metrics;
import org.funivan.lologa.algo.ga.genome.metric.MetricsInterface;
import org.funivan.lologa.algo.ga.genome.population.Population;
import org.funivan.lologa.algo.ga.genome.value.*;
import org.funivan.lologa.algo.ga.player.CalculatedResult;
import org.funivan.lologa.algo.ga.player.Player;
import org.funivan.lologa.algo.ga.player.PlayerInterface;
import org.funivan.lologa.algo.ga.player.ResultInterface;
import org.funivan.lologa.algo.gameplay.ClassicGamePlay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Cli {

    public static void main(String[] args) {
        final ClassicGamePlay gameplay = new ClassicGamePlay();
        final MetricsInterface metrics = new Metrics(new ListOf<>(
            new MaxScoreValue(),
            new RemovedTilesValue(),
            new AverageScoreValue(),
            new LockedValue(gameplay)
        ));

        final PlayerInterface startPlayer = new Player(
            new HashMap<String, Double>() {{
                this.put(new MaxScoreValue().type(), 1.0);
                this.put(new RemovedTilesValue().type(), 1.0);
                this.put(new AverageScoreValue().type(), 1.0);
                this.put(new LockedValue(gameplay).type(), 1.0);
            }},
            gameplay,
            metrics
        );

        ArrayList<PlayerInterface> players = new ArrayList<>();
        final int playersNum = 8;
        final Random rand = new Random();
        for (int i = 0; i < playersNum; i++) {
            players.add(new Population(0.001 * rand.nextInt(100)).populate(startPlayer, startPlayer));
        }
        int maxGenerations = 10;
        Iterable<ResultInterface> generation = new IterableOf<>();
        for (int g = 1; g < maxGenerations; g++) {
            for (PlayerInterface player : players) {
                final ResultInterface max = new CalculatedResult(player, gameplay, g * 1000);
                generation = new Joined<>(generation, new IterableOf<>(max));
                System.out.println("Player " + " Score " + max + " " + player.genome());
            }

            generation = new Limited<>(new Sorted<>(generation), playersNum / 2);

            // populate players

            System.out.println("Generation " + g);
            for (ResultInterface result : generation) {
                System.out.println("R " + result.toString() + " P " + result.player().genome());
            }
            players = new ArrayList<>();

            Iterator<ResultInterface> fathers = new Cycled<>(new Shuffled<>(new Limited<>(generation, playersNum / 4))).iterator();
            Iterator<ResultInterface> mothers = new Cycled<>(new Shuffled<>(new Skipped<>(generation, playersNum / 4))).iterator();
            System.out.println("New generation");

            while (players.size() < playersNum) {
                PlayerInterface newPlayer = new Population()
                    .populate(
                        fathers.next().player(),
                        mothers.next().player()
                    );
                players.add(newPlayer);
            }
        }

    }
}
