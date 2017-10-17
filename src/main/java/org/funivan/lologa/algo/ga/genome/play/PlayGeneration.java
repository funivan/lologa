package org.funivan.lologa.algo.ga.genome.play;

import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.Joined;
import org.funivan.lologa.algo.ga.genome.GenomeInterface;
import org.funivan.lologa.algo.ga.player.Player;
import org.funivan.lologa.algo.ga.player.PlayerInterface;
import org.funivan.lologa.board.BoardInterface;

public class PlayGeneration implements PlayGenerationInterface {
    private final BoardInterface board;

    public PlayGeneration(BoardInterface board) {
        this.board = board;
    }

    @Override
    public Iterable<PlayerInterface> play(Iterable<GenomeInterface> genomes) {
        Iterable<PlayerInterface> generation = new IterableOf<>();
        for (GenomeInterface genome : genomes) {
            final PlayerInterface max = new Player(genome, this.board);
            generation = new Joined<>(generation, new IterableOf<>(max));
        }
        return generation;
    }

}
