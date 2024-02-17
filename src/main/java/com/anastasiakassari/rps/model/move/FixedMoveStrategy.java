package com.anastasiakassari.rps.model.move;

import javax.validation.constraints.NotNull;

/**
 * Represents a strategy where the move is fixed.
 */
public class FixedMoveStrategy implements MoveStrategy {

    @NotNull(message = "Move cannot be null")
    private Move move;

    /**
     * Constructs a FixedMoveStrategy with the specified move.     *
     * @param move the fixed move to be made
     */
    public FixedMoveStrategy(Move move) {
        this.move = move;
    }

    /**
     * Returns a fixed move as the move to be made.
     * @return the move to be made
     */
    @Override
    public Move makeMove() {
        return move;
    }
}
