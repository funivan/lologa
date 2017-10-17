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


        val ratio = object : HashMap<ValueInterface, Double>() {
            init {
                this.put(AverageScoreValue(), 0.22679768211315168)
                this.put(MaxScoreValue(), 0.09360431752939613)
                this.put(LockedTilesValue(gameplay), 0.4423825016731838)
                this.put(PossibleMovesValue(gameplay), 0.022750644246770865)
                this.put(RemovedTilesValue(), 0.45553055373708135)
                this.put(RemovedTilesValue(), 0.45553055373708135)
            }
        }

        val metrics = Metrics(ratio.keys)
        val genomeData = HashMap<String, Double>()
        for (ratioValue in ratio.keys) {
            genomeData.put(ratioValue.type(), ratio[ratioValue])
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