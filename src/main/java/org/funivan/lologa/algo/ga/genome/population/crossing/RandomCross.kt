package org.funivan.lologa.algo.ga.genome.population.crossing

import org.funivan.lologa.algo.ga.genome.GenomeInterface
import java.util.*

class RandomCross : CrossingInterface {
    private val rand: Random

    init {
        this.rand = Random()
    }

    override fun cross(father: GenomeInterface, mother: GenomeInterface): HashMap<String, Double> {
        val result = HashMap<String, Double>()
        for (type in father.data().keys) {
            val target = if (this.rand.nextInt(100) > 50) father else mother
            result.put(type, target.data()[type])
        }
        return result
    }


}
