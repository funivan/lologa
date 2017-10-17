package org.funivan.lologa.algo.ga.player

import org.funivan.lologa.algo.ga.genome.GenomeInterface

interface PlayerInterface : Comparable<PlayerInterface> {

    fun genome(): GenomeInterface

    fun score(): Int


}
