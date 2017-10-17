package org.funivan.lologa.tile.Score

class Score(private val value: Int) : ScoreInterface {

    override fun value(): Int {
        return this.value
    }

    override fun toString(): String {
        return "Score{" + this.value() + '}'
    }
}
