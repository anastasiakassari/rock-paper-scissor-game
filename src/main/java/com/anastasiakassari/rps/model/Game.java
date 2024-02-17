package com.anastasiakassari.rps.model;

import com.anastasiakassari.rps.model.move.Move;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

/**
 * Represents a game of Rock, Paper, Scissors between two players.
 */
public class Game {
    @NotNull(message = "Players cannot be null")
    private final Player player1;
    @NotNull(message = "Players cannot be null")
    private final Player player2;
    @Positive(message = "Number of rounds must be positive")
    private final int rounds;
    private Optional<Player> winner;

    private final Logger logger = LoggerFactory.getLogger(Game.class);

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

        // Ensure that the number of rounds is positive
        if (rounds <= 0) {
            throw new IllegalArgumentException("Number of rounds must be positive.");
        }

        this.player1 = player1;
        this.player2 = player2;
        this.rounds = rounds;
        this.winner = Optional.empty();
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

        // Determine the overall winner
        if (player1Score > player2Score) {
            this.winner = Optional.of(player1);
        } else if (player1Score < player2Score) {
            this.winner = Optional.of(player2);
        }
    }

    /**
     * Retrieves the winner of the game.
     * @return an Optional containing the winning player or empty if there is no winner
     */
    public Optional<Player> getWinner() {
        return winner;
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
            logger.debug("Tie between {} and {} with moves {} and {}", player1.getName(), player2.getName(), player1Move, player2Move);
            return null;
        } else {
            logger.debug("Round {} between {} and {} with moves {} and {}", round, player1.getName(), player2.getName(), player1Move, player2Move);
            return player1Move.beats(player2Move) ? player1 : player2;
        }
    }
}
