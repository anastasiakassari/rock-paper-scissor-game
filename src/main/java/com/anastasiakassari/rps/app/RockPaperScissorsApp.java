package com.anastasiakassari.rps.app;

import com.anastasiakassari.rps.model.move.FixedMoveStrategy;
import com.anastasiakassari.rps.model.Game;
import com.anastasiakassari.rps.model.move.Move;
import com.anastasiakassari.rps.model.Player;
import com.anastasiakassari.rps.model.move.RandomMoveStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RockPaperScissorsApp {

    private static final Logger logger = LoggerFactory.getLogger(RockPaperScissorsApp.class);

    private static final int DEFAULT_ROUNDS = 100;
    private static final Move PLAYER_FIXED_MOVE = Move.PAPER;

    public static void main(String[] args) {

        logger.info("Rock, Paper, Scissors! Playing {} rounds...", DEFAULT_ROUNDS);

        Game game = new Game(
                new Player("A", new FixedMoveStrategy(PLAYER_FIXED_MOVE)),
                new Player("B", new RandomMoveStrategy()),
                DEFAULT_ROUNDS
        );
        game.play();

        logger.info("The winner of the game is: {}", game.getWinner().map(Player::getName).orElse("Nobody"));
    }
}