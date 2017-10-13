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
    public boolean equals(Object o) {
        boolean result = false;
        if (this == o) {
            result = true;
        } else if (o instanceof PositionInterface) {
            result = (((PositionInterface) o).row() == this.row() && ((PositionInterface) o).col() == this.col());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return 31 * this.row + this.col;
    }

}
