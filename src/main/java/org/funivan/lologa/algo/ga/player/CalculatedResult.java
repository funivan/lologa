package org.funivan.lologa.algo.ga.player;

import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.board.BoardInterface;
import org.funivan.lologa.board.boards.Complicated8To8Board;
import org.funivan.lologa.tile.Score.ScoreSum;

public class CalculatedResult implements ResultInterface {

    private final int maxMoves;
    private PlayerInterface player;
    private Integer score;
    private GameplayInterface gameplay;

    public CalculatedResult(PlayerInterface player, GameplayInterface gameplay, int maxMoves) {
        this.player = player;
        this.gameplay = gameplay;
        this.score = null;
        this.maxMoves = maxMoves;
    }

    @Override
    public PlayerInterface player() {
        return this.player;
    }

    @Override
    public int score() {
        if (this.score == null) {
            this.score = 0;
            int sum = 0;
            int max = 0;
            final int rounds = 20;
            for (int round = 0; round < rounds; round++) {
                BoardInterface board = new Complicated8To8Board(this.gameplay);
                int moves = 0;
                do {
                    board = board.interact(
                        this.player().find(
                            board.tiles()
                        ).position()
                    );
                    final int current = new ScoreSum(board.tiles()).value();
                    sum += current;
                    if (current > max) {
                        max = current;
                    } else {
                        break;
                    }

                } while (moves < this.maxMoves);
            }
            // max
            // this.score = max;
            // average
            this.score = sum / rounds;
        }
        return this.score;
    }

    @Override
    public int compareTo(ResultInterface result) {
        return Integer.compare(result.score(), this.score());
    }

    @Override
    public String toString() {
        return "Result{" + this.score() + '}';
    }

}
