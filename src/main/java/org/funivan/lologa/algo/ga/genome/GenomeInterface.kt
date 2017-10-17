package org.funivan.lologa.algo.ga.genome

import org.funivan.lologa.algo.find.one.TileFinder
import java.util.*

interface GenomeInterface : TileFinder {

    fun withData(genome: HashMap<String, Double>): GenomeInterface

    fun data(): HashMap<String, Double>

}
