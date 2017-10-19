package org.funivan.lologa.board.boards

import org.cactoos.iterable.Cycled
import org.cactoos.list.ListOf
import org.funivan.lologa.algo.gameplay.GameplayInterface
import org.funivan.lologa.board.Board
import org.funivan.lologa.iterable.Shuffled
import org.funivan.lologa.tile.Tile
import org.funivan.lologa.tile.position.Position
import org.funivan.lologa.tiles.Tiles
import java.awt.Color

@Suppress("unused")
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
                                Board.YELLOW,
                                Board.VIOLET
                        )
                )
        ),
        Tiles()
                .with(Tile(BLUE, Position(6, 1)))
                .with(Tile(BLUE, Position(6, 1)))
                .with(Tile(BLUE, Position(6, 2))).with(Tile(BLUE, Position(7, 2)))
                .with(Tile(BLUE, Position(6, 3)))
)
