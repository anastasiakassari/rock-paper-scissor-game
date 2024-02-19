package com.anastasiakassari.rps.model.move;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomMoveStrategyTest {
    @Test
    void testMakeMove() {
        RandomMoveStrategy strategy = new RandomMoveStrategy();
        // Make several moves and ensure they are within the valid range
        for (int i = 0; i < 1000; i++) {
            Move move = strategy.makeMove();
            assertNotNull(move);
            assertTrue(move == Move.ROCK || move == Move.PAPER || move == Move.SCISSORS);
        }
    }
}