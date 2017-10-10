package org.funivan.lologa.tile.Position;

public class Position implements PositionInterface {
    private final int row;
    private final int col;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public int row() {
        return this.row;
    }

    @Override
    public int col() {
        return this.col;
    }

    @Override
    public String toString() {
        return "Position{" + this.row + "x" + this.col + '}';
    }

    @Override
    public boolean same(PositionInterface target) {
        return (target.row() == this.row() && target.col() == this.col());
    }

}
