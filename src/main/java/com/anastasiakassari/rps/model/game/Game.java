package com.anastasiakassari.rps.model.game;

import com.anastasiakassari.rps.model.Player;
import com.anastasiakassari.rps.model.move.Move;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a game of Rock, Paper, Scissors between two players.
 */
public class Game {

    private final Player player1;
    private final Player player2;
    private final int rounds;
    private GameResult result;

    private final Logger logger = LoggerFactory.getLogger(Game.class);

    /**
     * Retrieves the first player of the game.
     * @return player1 of the game
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Retrieves the second player of the game.
     * @return player2 of the game
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Retrieves the result of the game.
     * @return the result of the game
     */
    public GameResult getResult() {
        return result;
    }

    /**
     * Constructs a single round game.
     * @param player1 the first player
     * @param player2 the second player
     */
    public Game(Player player1, Player player2) {
        this(player1, player2, 1);
    }

    /**
     * Constructs a game with a specified number of rounds.
     * @param player1 the first player
     * @param player2 the second player
     * @param rounds  the number of rounds to play
     */
    public Game(Player player1, Player player2, int rounds) {

        // Ensure that the players are not null
        if (player1 == null || player2 == null) {
            throw new IllegalArgumentException("Players cannot be null.");
        }

        // Ensure that the players are different
        if (player1.equals(player2)) {
            throw new IllegalArgumentException("Players cannot be the same.");
        }

        // Ensure that the number of rounds is positive
        if (rounds <= 0) {
            throw new IllegalArgumentException("Number of rounds must be positive.");
        }

        this.player1 = player1;
        this.player2 = player2;
        this.rounds = rounds;
    }

    /**
     * Simulates a series of rounds between two players and keeps track of the scores.
     */
    public void play() {
        int player1Score = 0;
        int player2Score = 0;

        // Play rounds and update scores
        for (int round = 0; round < rounds; round++) {
            Player roundWinner = playRound(player1, player2, round);
            if (roundWinner == player1) {
                player1Score++;
            } else if (roundWinner == player2) {
                player2Score++;
            }
        }

        // Log the results
        logger.info("Player {} wins {} of {} games", player1.getName(), player1Score, rounds);
        logger.info("Player {} wins {} of {} games", player2.getName(), player2Score, rounds);
        logger.info("Tie: {} of {} games", rounds - player1Score - player2Score, rounds);

        // Determine the overall game result
        if (player1Score > player2Score) {
            result = GameResult.PLAYER_ONE_WIN;
        } else if (player1Score < player2Score) {
            result = GameResult.PLAYER_TWO_WIN;
        } else {
            result = GameResult.TIE;
        }
    }

    /**
     * Plays a round of the game between two players.
     * @param  player1  the first player
     * @param  player2  the second player
     * @param  round    the current round number
     * @return          the winner of the round, or null in case of a tie
     */
    private Player playRound(Player player1, Player player2, int round) {
        Move player1Move = player1.makeMove();
        Move player2Move = player2.makeMove();
        if (player1Move == player2Move) {
            logger.debug("Round {} is a tie, both moves were {}", round, player1Move);
            return null;
        } else {
            logger.debug("Round {} with moves {} (player {}) and {} (player {})", round, player1Move, player1.getName(), player2Move, player2.getName());
            return player1Move.beats(player2Move) ? player1 : player2;
        }
    }
}