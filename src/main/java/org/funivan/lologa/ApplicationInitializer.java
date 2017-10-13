package org.funivan.lologa;

import org.cactoos.iterable.Cycled;
import org.cactoos.list.ListOf;
import org.funivan.lologa.iterable.Shuffled;
import org.funivan.lologa.tiles.Tiles;

import java.awt.*;

public class ApplicationInitializer {

    public static void main(String[] args) {
        new GeneralFrame(
            new Board(
                new Tiles(),
                8, 8,
                new Cycled<>(
                    new Shuffled<>(
                        new ListOf<>(
                            new Color(100, 200, 100),
                            new Color(250, 50, 50),
                            new Color(1, 90, 250),
                            new Color(255, 220, 40)
                        )
                    )
                )
            )

        );


    }

}