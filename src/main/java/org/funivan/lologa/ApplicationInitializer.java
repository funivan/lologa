package org.funivan.lologa;

import org.cactoos.iterable.Cycled;
import org.cactoos.list.ListOf;
import org.funivan.lologa.iterable.Shuffled;

import java.awt.*;
import java.io.IOException;

public class ApplicationInitializer {

    public static void main(String[] args) throws IOException {
        new GeneralFrame(
            new Cycled<>(
                new Shuffled<>(
                    new ListOf<>(
                        new Color(100, 200, 100),
                        new Color(250, 50, 50)
//                        new Color(1, 90, 250)
                    )
                )
            )
        );


    }

}