package org.funivan.lologa.gui

import java.awt.BorderLayout
import javax.swing.JFrame

class Window(board: GamePanel) : JFrame() {
    init {
        this.title = "Game Lolo GA"
        this.setSize(800, 800)
        this.layout = BorderLayout(0, 0)
        this.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        this.isVisible = true
        this.add(board)
    }

}
