package org.funivan.lologa.iterator

import org.cactoos.list.ListOf

class Shuffled<T>(val origin: Iterator<T>) : Iterator<T> {
    private var iter: Iterator<T> = ListOf<T>().iterator()
    private var shuffled = false;

    private fun shuffledIterator(): Iterator<T> {
        if (!this.shuffled) {
            var a = mutableListOf<T>()
            while (this.origin.hasNext()) {
                a.add(this.origin.next())
            }
            this.iter = a.iterator();
            this.shuffled = true;
        }
        return this.iter
    }

    override fun hasNext(): Boolean {
        return this.shuffledIterator().hasNext()
    }

    override fun next(): T {
        return this.shuffledIterator().next()
    }
}

