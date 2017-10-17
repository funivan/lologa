package org.funivan.lologa.iterable

class Shuffled<T>
/**
 * Ctor.
 *
 * @param src The underlying iterable
 */
(
        /**
         * Decorated iterable.
         */
        private val iterable: Iterable<T>) : Iterable<T> {

    override fun toString(): String {
        return this.iterable.toString()
    }

    override fun iterator(): Iterator<T> {
        return org.funivan.lologa.iterator.Shuffled(
                this.iterable.iterator()
        )
    }
}