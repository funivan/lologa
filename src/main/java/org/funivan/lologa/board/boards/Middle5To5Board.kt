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

class Middle5To5Board(gameplay: GameplayInterface)
    : Board (
        gameplay,
        5, 5,
        Cycled<Color>(
                Shuffled<Color>(
                        ListOf<Color>(
                                Board.BLUE,
                                Board.GREEN,
                                Board.RED
                        )
                )
        ),
        Tiles()
                .with(Tile(Board.BLUE, Position(3, 1)))
                .with(Tile(Board.BLUE, Position(3, 1)))
                .with(Tile(Board.BLUE, Position(3, 2))).with(Tile(Board.BLUE, Position(4, 2)))
                .with(Tile(Board.BLUE, Position(3, 3)))
)
