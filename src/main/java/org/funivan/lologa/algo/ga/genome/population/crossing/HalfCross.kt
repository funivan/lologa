package org.funivan.lologa.algo.ga.genome.population.crossing

import org.funivan.lologa.algo.ga.genome.GenomeInterface

class HalfCross : CrossingInterface {

    override fun cross(father: GenomeInterface, mother: GenomeInterface): HashMap<String, Double> {
        var result = HashMap(father.data())
        var i = 0;
        for (type in father.data().keys) {
            if (i % 2 == 0 && mother.data()[type] != null) {
                result[type] = mother.data()[type];
            }
            i++;
        }
        return result
    }


}
