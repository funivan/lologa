package org.funivan.lologa.algo.ga.genome

import org.funivan.lologa.algo.ga.player.PlayerInterface
import java.util.*

class Genomes(private val players: Iterable<PlayerInterface>) : Iterable<GenomeInterface> {

    override fun iterator(): Iterator<GenomeInterface> {
        val result = ArrayList<GenomeInterface>()
        for (player in this.players) {
            result.add(player.genome())
        }
        return result.iterator()
    }
}
