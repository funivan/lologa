package org.funivan.lologa.iterable

class Shuffled<T>(private val iterable: Iterable<T>) : Iterable<T> {

    override fun toString(): String {
        return this.iterable.toString()
    }

    override fun iterator(): Iterator<T> {
        return org.funivan.lologa.iterator.Shuffled(
                this.iterable.iterator()
        )
    }
}