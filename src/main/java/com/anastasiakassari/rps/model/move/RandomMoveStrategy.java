package com.anastasiakassari.rps.model.move;

import java.util.Random;

/**
 * Represents a strategy where the move is randomly generated.
 */
public class RandomMoveStrategy implements MoveStrategy {

    private static final Random RANDOM = new Random();

    /**
     * Generates a random move.
     * @return a randomly selected Move
     */
    @Override
    public Move makeMove() {
        return Move.values()[RANDOM.nextInt(Move.values().length)];
    }
}
