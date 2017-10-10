package org.funivan.lologa.iterable;

import java.util.Iterator;

public final class Shuffled<T> implements Iterable<T> {

    /**
     * Decorated iterable.
     */
    private final Iterable<T> iterable;


    /**
     * Ctor.
     *
     * @param src The underlying iterable
     */
    public Shuffled(final Iterable<T> src) {
        this.iterable = src;
    }

    @Override
    public String toString() {
        return this.iterable.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new org.funivan.lologa.iterator.Shuffled<>(
            this.iterable.iterator()
        );
    }
}