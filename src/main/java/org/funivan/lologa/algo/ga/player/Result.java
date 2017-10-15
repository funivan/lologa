package org.funivan.lologa.algo.ga.player;

public class Result implements ResultInterface {
    private final PlayerInterface player;
    private final int score;

    public Result(PlayerInterface player, int score) {
        this.player = player;
        this.score = score;
    }

    @Override
    public PlayerInterface player() {
        return this.player;
    }

    @Override
    public int score() {
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
