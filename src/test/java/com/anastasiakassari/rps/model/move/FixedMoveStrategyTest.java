package com.anastasiakassari.rps.model.move;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FixedMoveStrategyTest {

    @Test
    void testMakeMove() {
        Move move1 = Move.ROCK;
        Move move2 = Move.SCISSORS;

        FixedMoveStrategy strategy1 = new FixedMoveStrategy(move1);
        FixedMoveStrategy strategy2 = new FixedMoveStrategy(move2);

        assertEquals(move1, strategy1.makeMove());
        assertEquals(move2, strategy2.makeMove());
    }

    @Test
    void testFixedMoveStrategyWithNullMove() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new FixedMoveStrategy(null));
        assertEquals("Move cannot be null", exception.getMessage());
    }

    @Test
    void testFixedMoveStrategyIsEqual() {
        FixedMoveStrategy strategy1 = new FixedMoveStrategy(Move.PAPER);
        FixedMoveStrategy strategy2 = new FixedMoveStrategy(Move.PAPER);

        assertEquals(strategy1, strategy2);

        strategy2 = new FixedMoveStrategy(Move.ROCK);
        assertNotEquals(strategy1, strategy2);
    }
}
