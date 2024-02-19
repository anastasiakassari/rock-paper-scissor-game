package com.anastasiakassari.rps.model.game;

import com.anastasiakassari.rps.model.Player;
import com.anastasiakassari.rps.model.move.FixedMoveStrategy;
import com.anastasiakassari.rps.model.move.Move;
import com.anastasiakassari.rps.model.move.RandomMoveStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameIntegrationTest {

    @Test
    void testSingleRoundGameWithFixedMoveStrategyPlayers() {
        Player player1 = new Player("A", new FixedMoveStrategy(Move.ROCK));
        Player player2 = new Player("B", new FixedMoveStrategy(Move.SCISSORS));
        Game game = new Game(player1, player2);

        GameResult result = game.getResult();
        assertNull(result);

        game.play();
        result = game.getResult();

        assertNotNull(result);
        assertEquals(GameResult.PLAYER_ONE_WIN, result);
    }

    @Test
    void testMultiRoundGameWithDifferentMoveStrategyPlayers() {

        Player player1 = new Player("A", new FixedMoveStrategy(Move.ROCK));
        Player player2 = new Player("B", new RandomMoveStrategy());
        Game game = new Game(player1, player2, 3);
        GameResult result = game.getResult();
        assertNull(result);

        game.play();
        result = game.getResult();

        assertNotNull(result);
        assertTrue(result == GameResult.PLAYER_ONE_WIN || result == GameResult.PLAYER_TWO_WIN || result == GameResult.TIE);
    }

}
