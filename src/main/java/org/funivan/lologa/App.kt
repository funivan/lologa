package org.funivan.lologa

import org.funivan.lologa.algo.ga.genome.Genome
import org.funivan.lologa.algo.ga.genome.metric.Metrics
import org.funivan.lologa.algo.ga.genome.value.*
import org.funivan.lologa.algo.gameplay.ClassicGamePlay
import org.funivan.lologa.board.BoardInterface
import org.funivan.lologa.board.boards.Middle5To5Board
import org.funivan.lologa.gui.GamePanel
import org.funivan.lologa.gui.Window
import java.util.*

object App {

    @JvmStatic
    fun main(args: Array<String>) {
        val gameplay = ClassicGamePlay()
        var board: BoardInterface = Middle5To5Board(gameplay)
        val gamePanel = GamePanel(board)
        Window(gamePanel)

        val ratio: HashMap<ValueInterface, Double> = hashMapOf(
                AverageScoreValue() to 0.7475172379772614,
                MaxScoreValue() to 0.2864582461582227,
                LockedTilesValue(gameplay) to 0.38417682863787844,
                PossibleMovesValue(gameplay) to 0.0016352215737979459,
                RemovedTilesValue() to 0.7150867913184329
        )

        val metrics = Metrics(ratio.keys)
        val genomeData = HashMap<String, Double>()
        for ((type, value) in ratio) {
            genomeData.set(type.type(), value)
        }

        val player = Genome(genomeData, gameplay, metrics)

        while (true) {
            try {
                Thread.sleep(100)
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