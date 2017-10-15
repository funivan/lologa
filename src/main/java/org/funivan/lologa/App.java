package org.funivan.lologa;

import org.cactoos.iterable.Cycled;
import org.cactoos.list.ListOf;
import org.funivan.lologa.algo.ga.genome.Genome;
import org.funivan.lologa.algo.ga.genome.metric.Metrics;
import org.funivan.lologa.algo.ga.genome.metric.MetricsInterface;
import org.funivan.lologa.algo.ga.genome.value.AverageScoreValue;
import org.funivan.lologa.algo.ga.genome.value.LockedValue;
import org.funivan.lologa.algo.ga.genome.value.RemovedTilesValue;
import org.funivan.lologa.algo.ga.genome.value.ValueInterface;
import org.funivan.lologa.algo.ga.player.Player;
import org.funivan.lologa.algo.ga.player.PlayerInterface;
import org.funivan.lologa.algo.gameplay.ClassicGamePlay;
import org.funivan.lologa.gui.Board;
import org.funivan.lologa.gui.Window;
import org.funivan.lologa.iterable.Shuffled;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Tiles;

import java.awt.*;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        final ClassicGamePlay gameplay = new ClassicGamePlay();
        final HashMap<ValueInterface, Double> ratio = new HashMap<ValueInterface, Double>() {{
            this.put(new RemovedTilesValue(), 0.1);
            this.put(new LockedValue(gameplay), 0.02);
            this.put(new AverageScoreValue(), 0.01);
        }};
        final MetricsInterface metrics = new Metrics(ratio.keySet());
        HashMap<String, Double> genomeData = new HashMap<>();
        for (ValueInterface ratioValue : ratio.keySet()) {
            genomeData.put(ratioValue.type(), ratio.get(ratioValue));
        }
        final Genome genome = new Genome(genomeData);
        final PlayerInterface player = new Player(genome, gameplay, metrics);

        Board board = new Board(
            gameplay,
            3, 3,
            new Cycled<>(
                new Shuffled<>(
                    new ListOf<>(
                        new Color(100, 200, 100),
                        new Color(250, 50, 50)
//                        new Color(1, 90, 250)
//                        new Color(255, 220, 40)
                    )
                )
            ),
            new Tiles()
        );

        new Window(board);

        while (true) {
            try {
                Thread.sleep(1000);
                TileInterface tile = player.find(board.tiles());
                if (board.tiles().has(tile.position())) {
                    System.out.println("Click on tile : " + tile);
                    board.interact(tile.position());
                } else {
                    System.out.println("Can not click on tile : " + tile);
                    System.out.println("The End");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}