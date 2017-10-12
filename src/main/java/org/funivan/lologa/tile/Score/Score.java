package org.funivan.lologa.tile.Score;

public class Score implements ScoreInterface {
    private int value;

    public Score(int value) {
        this.value = value;
    }

    @Override
    public int value() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Score{" + this.value() + '}';
    }
}
