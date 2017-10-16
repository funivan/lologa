package org.funivan.lologa.algo.ga.genome;

import org.funivan.lologa.algo.ga.player.PlayerInterface;

import java.util.ArrayList;
import java.util.Iterator;

public class Genomes implements Iterable<GenomeInterface> {
    private final Iterable<PlayerInterface> players;

    public Genomes(Iterable<PlayerInterface> players) {
        this.players = players;
    }

    @Override
    public Iterator<GenomeInterface> iterator() {
        ArrayList<GenomeInterface> result = new ArrayList<>();
        for (PlayerInterface player : this.players) {
            result.add(player.genome());
        }
        return result.iterator();
    }
}
