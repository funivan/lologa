package org.funivan.lologa;

import org.cactoos.iterable.Cycled;
import org.cactoos.list.ListOf;
import org.funivan.lologa.algo.ga.genome.Genome;
import org.funivan.lologa.algo.ga.genome.metric.Metrics;
import org.funivan.lologa.algo.ga.genome.metric.MetricsInterface;
import org.funivan.lologa.algo.ga.genome.value.LockedValue;
import org.funivan.lologa.algo.ga.genome.value.RemovedTilesValue;
import org.funivan.lologa.algo.ga.player.Player;
import org.funivan.lologa.algo.ga.player.PlayerInterface;
import org.funivan.lologa.algo.gameplay.ClassicGamePlay;
import org.funivan.lologa.iterable.Shuffled;
import org.funivan.lologa.tile.TileInterface;
import org.funivan.lologa.tiles.Tiles;

import java.awt.*;
import java.util.HashMap;

public class ApplicationInitializer {

    public static void main(String[] args) {
        final ClassicGamePlay gameplay = new ClassicGamePlay();
        final MetricsInterface metrics = new Metrics(
            new ListOf<>(
                new RemovedTilesValue(),
//                new PossibleMovesValue(gameplay)
                new LockedValue(gameplay)
            )
        );
        final Genome genome = new Genome(
            new HashMap<String, Double>() {{
//                this.put(new RemovedTilesValue().type(), 0.1);
                this.put(new LockedValue(gameplay).type(), 0.8);
            }}
        );
        final PlayerInterface player = new Player(genome, gameplay, metrics);

        Board board = new Board(
            gameplay,
            metrics, 3, 3,
            new Cycled<>(
                new Shuffled<>(
                    new ListOf<>(
                        new Color(100, 200, 100),
                        new Color(250, 50, 50)
//                        new Color(1, 90, 250),
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
                    System.out.println("Cant click on tile : " + tile);
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}