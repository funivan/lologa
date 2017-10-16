package org.funivan.lologa;

import org.funivan.lologa.algo.ga.genome.Genome;
import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.algo.ga.genome.metric.Metrics;
import org.funivan.lologa.algo.ga.genome.metric.MetricsInterface;
import org.funivan.lologa.algo.ga.genome.value.*;
import org.funivan.lologa.algo.gameplay.ClassicGamePlay;
import org.funivan.lologa.board.BoardInterface;
import org.funivan.lologa.board.boards.Middle5To5Board;
import org.funivan.lologa.gui.GamePanel;
import org.funivan.lologa.gui.Window;
import org.funivan.lologa.tile.TileInterface;

import java.util.HashMap;

public class App {

    public static void main(String[] args) {
        final ClassicGamePlay gameplay = new ClassicGamePlay();
        BoardInterface board = new Middle5To5Board(gameplay);
        final GamePanel gamePanel = new GamePanel(board);
        new Window(gamePanel);


        HashMap<ValueInterface, Double> ratio = new HashMap<ValueInterface, Double>() {{
//            this.put(new AverageScoreValue(), 1.605013907671868E-297);
//            this.put(new MaxScoreValue(), 3.5567147381611746E-297);
//            this.put(new LockedValue(gameplay), 2.3416365059501685E-297);
//            this.put(new RemovedTilesValue(), 4.8370809244881494E-297);
//
            this.put(new AverageScoreValue(), 7.981118990435994);
            this.put(new MaxScoreValue(), 17.348301520296374);
            this.put(new LockedValue(gameplay), 8.391660879765636);
            this.put(new RemovedTilesValue(), 13.614258698412117);
        }};



        final MetricsInterface metrics = new Metrics(ratio.keySet());
        HashMap<String, Double> genomeData = new HashMap<>();
        for (ValueInterface ratioValue : ratio.keySet()) {
            genomeData.put(ratioValue.type(), ratio.get(ratioValue));
        }

        final GenomeInterface player = new Genome(genomeData, gameplay, metrics);

        while (true) {
            try {
                Thread.sleep(100);
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