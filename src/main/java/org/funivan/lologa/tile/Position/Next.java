package org.funivan.lologa.tile.Position;

import org.funivan.lologa.tile.TileInterface;

public class Next implements PositionInterface {
    private final PositionInterface start;
    private final int rowStep;
    private final int colStep;

    public Next(PositionInterface start, int rowStep, int colStep) {
        this.start = start;
        this.rowStep = rowStep;
        this.colStep = colStep;
    }

    public Next(TileInterface start, int rowStep, int colStep) {
        this(start.position(), rowStep, colStep);
    }

    @Override
    public final int row() {
        return this.start.row() + this.rowStep;
    }

    @Override
    public final int col() {
        return this.start.col() + this.colStep;
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
        return 31 * this.row() + this.col();
    }


    public static class Top extends Next {
        public Top(TileInterface start) {
            super(start, -1, 0);
        }
    }

    public static class Right extends Next {
        public Right(TileInterface start) {
            super(start, 0, 1);
        }
    }

    public static class Bottom extends Next {
        public Bottom(TileInterface start) {
            super(start, 1, 0);
        }
        public Bottom(PositionInterface start) {
            super(start, 1, 0);
        }
    }

    public static class Left extends Next {
        public Left(TileInterface start) {
            super(start, 0, -1);
        }
    }
}
