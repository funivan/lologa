package org.funivan.lologa

import org.funivan.lologa.algo.ga.genome.Genome
import org.funivan.lologa.algo.ga.genome.metric.Metrics
import org.funivan.lologa.algo.ga.genome.value.*
import org.funivan.lologa.algo.gameplay.ClassicGamePlay
import org.funivan.lologa.board.BoardInterface
import org.funivan.lologa.board.boards.Complicated8To8Board
import org.funivan.lologa.gui.GamePanel
import org.funivan.lologa.gui.Window
import java.util.*

object App {

    @JvmStatic
    fun main(args: Array<String>) {
        val gameplay = ClassicGamePlay()
        var board: BoardInterface = Complicated8To8Board(gameplay)
        val gamePanel = GamePanel(board)
        Window(gamePanel)

        val ratio: HashMap<ScoreInterface, Double> = hashMapOf(
                AverageScore() to 0.4540566695683766,
                MaxScoreValue() to 0.8678220533407088,
                LockedTiles(gameplay) to 1.0633201054831722,
                PossibleMovesValue(gameplay) to 0.0013195811496427012,
                RemovedTilesValue() to 0.896611933783648
        )

        val metrics = Metrics(ratio.keys)
        val genomeData = HashMap<String, Double>()
        for ((type, value) in ratio) {
            genomeData.set(type.type(), value)
        }

        val player = Genome(genomeData, gameplay, metrics)
        while (true) {
            try {
                Thread.sleep(2000)
                val tile = player.find(board.tiles())
                if (board.tiles().has(tile.position())) {
                    println("Click on tile : " + tile)
                    board = board.interact(tile.position())
                    gamePanel.setBoard(board)
                } else {
                    println("Can not click on tile : " + tile)
                    println("The End")
                    break
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }

    }

}