package com.anastasiakassari.rps.model;

import com.anastasiakassari.rps.model.move.FixedMoveStrategy;
import com.anastasiakassari.rps.model.move.Move;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerTest {

    @Test
    void testPlayer() {
        Move move = Move.ROCK;
        String name = "Player";
        Player player = new Player(name, new FixedMoveStrategy(move));

        assertEquals(name, player.getName());
        assertEquals(move, player.makeMove());
    }

    @Test
    void testPlayerWithNullName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player(null, new FixedMoveStrategy(Move.ROCK)));
        assertEquals("Name cannot be null.", exception.getMessage());
    }

    @Test
    void testPlayerWithNullMove() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Player("Player", null));
        assertEquals("Move strategy cannot be null.", exception.getMessage());
    }

    @Test
    void testEquals() {
        Move move = Move.ROCK;
        String name = "Player";
        Player player1 = new Player(name, new FixedMoveStrategy(move));
        Player player2 = new Player(name, new FixedMoveStrategy(move));

        assertEquals(player1, player2);

        player2 = new Player(name, new FixedMoveStrategy(Move.SCISSORS));
        assertNotEquals(player1, player2);
    }
}