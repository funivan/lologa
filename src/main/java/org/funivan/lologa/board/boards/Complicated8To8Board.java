package org.funivan.lologa.board.boards;

import org.cactoos.iterable.Cycled;
import org.cactoos.list.ListOf;
import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.board.Board;
import org.funivan.lologa.iterable.Shuffled;
import org.funivan.lologa.tiles.Tiles;

public class Complicated8To8Board extends Board {

    public Complicated8To8Board(GameplayInterface gameplay) {
        super(
            gameplay,
            8,
            8,
            new Cycled<>(
                new Shuffled<>(
                    new ListOf<>(
                        GREEN,
                        RED,
                        BLUE,
                        YELLOW
                    )
                )
            ),
            new Tiles()
        );
    }
}
