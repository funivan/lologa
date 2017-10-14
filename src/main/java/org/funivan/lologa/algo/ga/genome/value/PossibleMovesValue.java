package org.funivan.lologa.algo.ga.genome.value;

import org.funivan.lologa.algo.find.multiple.PossibleMoves;
import org.funivan.lologa.algo.gameplay.GameplayInterface;
import org.funivan.lologa.tiles.TilesInterface;

public class PossibleMovesValue implements ValueInterface {

    private final PossibleMoves possibleMoves;

    public PossibleMovesValue(GameplayInterface gameplay) {
        this.possibleMoves = new PossibleMoves(gameplay.minimum());
    }

    @Override
    public String type() {
        return "possible_moves";
    }

    @Override
    public Double value(TilesInterface tiles) {
        return (double) this.possibleMoves.handle(tiles).size();
    }
}
