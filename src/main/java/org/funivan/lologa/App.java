package org.funivan.lologa;

import org.funivan.lologa.algo.ga.genome.Genome;
import org.funivan.lologa.algo.ga.genome.metric.Metrics;
import org.funivan.lologa.algo.ga.genome.metric.MetricsInterface;
import org.funivan.lologa.algo.ga.genome.value.*;
import org.funivan.lologa.algo.ga.player.Player;
import org.funivan.lologa.algo.ga.player.PlayerInterface;
import org.funivan.lologa.algo.gameplay.ClassicGamePlay;
import org.funivan.lologa.board.BoardInterface;
import org.funivan.lologa.board.boards.Complicated8To8Board;
import org.funivan.lologa.gui.GamePanel;
import org.funivan.lologa.gui.Window;
import org.funivan.lologa.tile.TileInterface;

import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        final ClassicGamePlay gameplay = new ClassicGamePlay();
        final HashMap<ValueInterface, Double> ratio = new HashMap<ValueInterface, Double>() {{
            this.put(new MaxScoreValue(), 0.01);
            this.put(new RemovedTilesValue(), 0.2);
            this.put(new LockedValue(gameplay), 0.3);
            this.put(new AverageScoreValue(), 0.03);
        }};
        final MetricsInterface metrics = new Metrics(ratio.keySet());
        HashMap<String, Double> genomeData = new HashMap<>();
        for (ValueInterface ratioValue : ratio.keySet()) {
            genomeData.put(ratioValue.type(), ratio.get(ratioValue));
        }

        BoardInterface board = new Complicated8To8Board(gameplay);
        final GamePanel gamePanel = new GamePanel(board);
        new Window(gamePanel);

        final PlayerInterface player = new Player(genomeData, gameplay, metrics);
        while (true) {
            try {
                Thread.sleep(1000);
                TileInterface tile = player.find(board.tiles());
                if (board.tiles().has(tile.position())) {
                    System.out.println("Click on tile : " + tile);
                    board = board.interact(tile.position());
                    gamePanel.setBoard(board);
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