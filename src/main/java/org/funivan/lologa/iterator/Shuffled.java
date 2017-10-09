package org.funivan.lologa.iterator;

import org.cactoos.scalar.StickyScalar;
import org.cactoos.scalar.SyncScalar;
import org.cactoos.scalar.UncheckedScalar;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public final class Shuffled<T> implements Iterator<T> {
    private final UncheckedScalar<Iterator<T>> scalar;

    public Shuffled(Iterator<T> iterator) {
        this.scalar = new UncheckedScalar(
            new SyncScalar(
                new StickyScalar(() -> {
                    LinkedList items = new LinkedList();
                    while (iterator.hasNext()) {
                        items.add(iterator.next());
                    }
                    Collections.shuffle(items);
                    return items.iterator();
                })
            )
        );
    }

    public boolean hasNext() {
        return this.scalar.value().hasNext();
    }

    public T next() {
        return this.scalar.value().next();
    }
}

