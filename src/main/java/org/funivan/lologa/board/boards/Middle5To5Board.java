package org.funivan.lologa.board.boards;

import org.cactoos.iterable.Cycled;
import org.cactoos.list.ListOf;
import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.board.Board;
import org.funivan.lologa.iterable.Shuffled;
import org.funivan.lologa.tile.Position.Position;
import org.funivan.lologa.tile.Tile;
import org.funivan.lologa.tiles.Tiles;

import java.awt.*;

public class Middle5To5Board extends Board {
    public Middle5To5Board(GameplayInterface gameplay) {
        super(
            gameplay,
            5,
            5,
            new Cycled<>(
                new Shuffled<>(
                    new ListOf<>(
                        Board.BLUE,
                        Board.GREEN,
                        Board.RED
                    )
                )
            ),
            new Tiles()
                .with(new Tile(Board.BLUE, new Position(3, 1)))
                .with(new Tile(Board.BLUE, new Position(3, 2)))
                .with(new Tile(Board.BLUE, new Position(3, 3)))
        );
    }
}
