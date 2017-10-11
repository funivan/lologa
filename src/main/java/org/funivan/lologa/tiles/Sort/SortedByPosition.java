package org.funivan.lologa.tiles.Sort;

import org.funivan.lologa.tile.Position.PositionInterface;
import org.funivan.lologa.tile.TileInterface;

import java.util.Comparator;

public class SortedByPosition implements Comparator<TileInterface> {
    @Override
    public int compare(TileInterface a, TileInterface b) {
        final PositionInterface positionA = a.position();
        final PositionInterface positionB = b.position();
        final int indexA = positionA.row() * positionA.row() * 10 + positionA.col();
        final int indexB = positionB.row() * positionB.row() * 10 + positionB.col();
        return (indexA == indexB
            ? 0
            : indexA > indexB ? 1 : -1
        );
    }
}
