package org.funivan.lologa.tiles.Filter;

import org.cactoos.Func;
import org.cactoos.collection.Filtered;
import org.cactoos.iterable.IterableOf;
import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;

import java.util.Collection;

public class IndexFilter implements Func<TileInterface, Boolean> {

    private ListOf<Integer> indexes;

    public IndexFilter(ListOf<Integer> indexes) {
        this.indexes = indexes;
    }

    public IndexFilter(int index) {
        this.indexes = new ListOf<Integer>(index);
    }

    @Override
    public Boolean apply(TileInterface tileInterface) throws Exception {
        return this.indexes.contains(
                tileInterface.index()
        );
    }
}
