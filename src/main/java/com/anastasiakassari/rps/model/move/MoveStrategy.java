package com.anastasiakassari.rps.model.move;

/**
 * Represents a method to determine the move to be made.
 * @return the Move chosen by the strategy
 */
public interface MoveStrategy {
    /**
     * Represents a method to determine the move to be made.
     * @return the Move chosen by the strategy
     */
    Move makeMove();
}
