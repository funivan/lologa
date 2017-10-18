package org.funivan.lologa.iterator

import org.cactoos.list.ListOf
import java.util.*

class Shuffled<T>(val origin: Iterator<T>) : Iterator<T> {
    private var iter: Iterator<T> = ListOf<T>().iterator()
    private var shuffled = false;

    private fun shuffledIterator(): Iterator<T> {
        if (!this.shuffled) {
            var a = mutableListOf<T>()
            while (this.origin.hasNext()) {
                a.add(this.origin.next())
            }
            Collections.shuffle(a);
            this.iter = a.iterator();
            this.shuffled = true;
        }
        return this.iter
    }

    override fun hasNext(): Boolean {
        return shuffledIterator().hasNext()
    }

    override fun next(): T {
        return this.shuffledIterator().next()
    }
}

