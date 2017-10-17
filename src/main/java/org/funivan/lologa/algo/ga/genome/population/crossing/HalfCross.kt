package org.funivan.lologa.algo.ga.genome.population.crossing

import org.funivan.lologa.algo.ga.genome.GenomeInterface
import java.util.*

class HalfCross : CrossingInterface {

    override fun cross(father: GenomeInterface, mother: GenomeInterface): HashMap<String, Double> {
        val result = HashMap<String, Double>()
        var takeMother = false
        for (type in father.data().keys) {
            val target = if (takeMother) mother else father
            result.put(type, target.data()[type])
            takeMother = !takeMother
        }
        return result
    }


}
