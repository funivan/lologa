package org.funivan.lologa.board.boards

import org.cactoos.iterable.Cycled
import org.cactoos.list.ListOf
import org.funivan.lologa.algo.gameplay.GameplayInterface
import org.funivan.lologa.board.Board
import org.funivan.lologa.iterable.Shuffled
import org.funivan.lologa.tiles.Tiles
import java.awt.Color

class Complicated8To8Board(gameplay: GameplayInterface)
    : Board(
        gameplay,
        8, 8,
        Cycled<Color>(
                Shuffled<Color>(
                        ListOf<Color>(
                                Board.GREEN,
                                Board.RED,
                                Board.BLUE,
                                Board.YELLOW
                        )
                )
        ),
        Tiles()
)
