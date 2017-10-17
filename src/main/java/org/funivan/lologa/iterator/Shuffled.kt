package org.funivan.lologa.iterator

import org.cactoos.scalar.StickyScalar
import org.cactoos.scalar.SyncScalar
import org.cactoos.scalar.UncheckedScalar
import java.util.*

class Shuffled<T>(iterator: Iterator<T>) : Iterator<T> {
    private val scalar: UncheckedScalar<Iterator<T>>

    init {
        this.scalar = UncheckedScalar(
                SyncScalar(
                        StickyScalar {
                            val items = LinkedList()
                            while (iterator.hasNext()) {
                                items.add(iterator.next())
                            }
                            Collections.shuffle(items)
                            items.iterator()
                        }
                )
        )
    }

    override fun hasNext(): Boolean {
        return this.scalar.value().hasNext()
    }

    override fun next(): T {
        return this.scalar.value().next()
    }
}

