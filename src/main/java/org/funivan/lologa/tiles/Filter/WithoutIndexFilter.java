package org.funivan.lologa.tiles.Filter;

import org.cactoos.Func;
import org.cactoos.list.ListOf;
import org.funivan.lologa.tile.TileInterface;

public class WithoutIndexFilter implements Func<TileInterface, Boolean> {

    private ListOf<Integer> indexes;


    public WithoutIndexFilter(int index) {
        this.indexes = new ListOf<Integer>(index);
    }

    @Override
    public Boolean apply(TileInterface tileInterface) throws Exception {
        return !this.indexes.contains(
            tileInterface.index()
        );
    }

}
