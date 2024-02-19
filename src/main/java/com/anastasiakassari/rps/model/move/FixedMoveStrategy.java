package com.anastasiakassari.rps.model.move;

/**
 * Represents a strategy where the move is fixed.
 */
public class FixedMoveStrategy implements MoveStrategy {

    private final Move move;

    /**
     * Constructs a FixedMoveStrategy with the specified move.
     * @param move the fixed move to be made
     */
    public FixedMoveStrategy(Move move) {
        if (move == null) {
            throw new IllegalArgumentException("Move cannot be null");
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return move == ((FixedMoveStrategy) o).move;
    }
}
