package com.anastasiakassari.rps.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class Game {
    @NotNull(message = "Players cannot be null")
    private final Player player1;
    @NotNull(message = "Players cannot be null")
    private final Player player2;
    @Positive(message = "Number of rounds must be positive")
    private final int rounds;

    private final Logger logger = LoggerFactory.getLogger(Game.class);

    public Game(Player player1, Player player2) {
        this(player1, player2, 1);
    }

    public Game(Player player1, Player player2, int rounds) {
        this.player1 = player1;
        this.player2 = player2;

        // Ensure that rounds is positive
        if (rounds <= 0) {
            throw new IllegalArgumentException("Number of rounds must be positive.");
        }

        // Ensure that the number of moves matches the number of rounds for each player
        if (player1.moves.size() != rounds || player2.moves.size() != rounds) {
            throw new IllegalArgumentException("Number of moves must match the number of rounds for each player.");
        }

        this.rounds = rounds;
    }

    public Player winner() {
        int player1Score = 0;
        int player2Score = 0;
        for (int round = 0; round < rounds; round++) {
            Player winner = play(player1, player2, round);
            if (winner == player1) {
                player1Score++;
            } else if (winner == player2) {
                player2Score++;
            }
        }
        logger.info("Player {} wins {} of {} games", player1.getName(), player1Score, rounds);
        logger.info("Player {} wins {} of {} games", player2.getName(), player2Score, rounds);
        logger.info("Tie: {} of {} games", rounds - player1Score - player2Score, rounds);
        if (player1Score > player2Score) {
            return player1;
        } else if (player1Score < player2Score) {
            return player2;
        } else {
            return null;
        }
    }

    private Player play(Player player1, Player player2, int round) {
        Move player1Move = player1.getMove(round);
        Move player2Move = player2.getMove(round);
        if (player1Move == player2Move) {
            logger.debug("Tie between {} and {} with moves {} and {}", player1.getName(), player2.getName(), player1Move, player2Move);
            return null;
        } else {
            logger.debug("Round {} between {} and {} with moves {} and {}", round, player1.getName(), player2.getName(), player1Move, player2Move);
            return player1Move.beats(player2Move) ? player1 : player2;
        }
    }
}
