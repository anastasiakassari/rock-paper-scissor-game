package com.anastasiakassari.rps.model.game;

import com.anastasiakassari.rps.model.Player;
import com.anastasiakassari.rps.model.move.Move;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class GameTest {

    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        player1 = mock(Player.class);
        player2 = mock(Player.class);
    }

    @Test
    void testSingleRoundGame() {
        when(player1.getName()).thenReturn("A");
        when(player1.makeMove()).thenReturn(Move.ROCK);

        when(player2.getName()).thenReturn("B");
        when(player2.makeMove()).thenReturn(Move.SCISSORS);

        Game game = new Game(player1, player2);
        game.play();

        GameResult result = game.getResult();
        assertNotNull(result);
        assertEquals(GameResult.PLAYER_ONE_WIN, result);
    }

    @Test
    void testMultiRoundGame() {
        when(player1.getName()).thenReturn("A");
        when(player1.makeMove()).thenReturn(Move.ROCK);

        when(player2.getName()).thenReturn("B");
        when(player2.makeMove()).thenReturn(Move.SCISSORS);

        Game game = new Game(player1, player2, 3);
        game.play();

        GameResult result = game.getResult();
        assertNotNull(result);
        assertEquals(GameResult.PLAYER_ONE_WIN, result);
    }

    @Test
    void testSingleRoundTieGame() {
        when(player1.getName()).thenReturn("A");
        when(player1.makeMove()).thenReturn(Move.ROCK);

        when(player2.getName()).thenReturn("B");
        when(player2.makeMove()).thenReturn(Move.ROCK);

        Game game = new Game(player1, player2);
        game.play();

        GameResult result = game.getResult();
        assertNotNull(result);
        assertEquals(GameResult.TIE, result);
    }

    @Test
    void testMultiRoundTieGame() {
        when(player1.getName()).thenReturn("A");
        when(player1.makeMove()).thenReturn(Move.ROCK);

        when(player2.getName()).thenReturn("B");
        when(player2.makeMove()).thenReturn(Move.ROCK);

        Game game = new Game(player1, player2, 3);
        game.play();

        GameResult result = game.getResult();
        assertNotNull(result);
        assertEquals(GameResult.TIE, result);
    }

    @Test
    void testGameWithNoRounds() {

        when(player1.getName()).thenReturn("A");
        when(player1.makeMove()).thenReturn(Move.ROCK);

        when(player2.getName()).thenReturn("B");
        when(player2.makeMove()).thenReturn(Move.SCISSORS);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Game(player1, player2, 0));
        assertEquals("Number of rounds must be positive.", exception.getMessage());
    }

    @Test
    void testGameWithInvalidRounds() {
        when(player1.getName()).thenReturn("A");
        when(player1.makeMove()).thenReturn(Move.ROCK);

        when(player2.getName()).thenReturn("B");
        when(player2.makeMove()).thenReturn(Move.SCISSORS);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Game(player1, player2, -1));
        assertEquals("Number of rounds must be positive.", exception.getMessage());
    }

    @Test
    void testGameWithNullPlayer() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Game(null, null));
        assertEquals("Players cannot be null.", exception.getMessage());
    }

    @Test
    void testGetGameResultWhenGameIsNotFinished() {
        when(player1.getName()).thenReturn("A");
        when(player1.makeMove()).thenReturn(Move.ROCK);

        when(player2.getName()).thenReturn("B");
        when(player2.makeMove()).thenReturn(Move.SCISSORS);

        Game game = new Game(player1, player2);

        GameResult result = game.getResult();
        assertNull(result);
    }

}