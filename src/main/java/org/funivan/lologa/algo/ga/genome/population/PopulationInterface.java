package org.funivan.lologa.algo.ga.genome.population;

import org.funivan.lologa.algo.ga.player.PlayerInterface;

public interface PopulationInterface {

    PlayerInterface populate(PlayerInterface father, PlayerInterface mother);

}
