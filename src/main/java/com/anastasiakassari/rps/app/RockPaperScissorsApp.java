package com.anastasiakassari.rps.app;

import com.anastasiakassari.rps.model.Player;
import com.anastasiakassari.rps.model.game.Game;
import com.anastasiakassari.rps.model.game.GameResult;
import com.anastasiakassari.rps.model.move.FixedMoveStrategy;
import com.anastasiakassari.rps.model.move.Move;
import com.anastasiakassari.rps.model.move.RandomMoveStrategy;
import com.anastasiakassari.rps.model.move.UserInputMoveStrategy;
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

        GameResult result = game.getResult();
        String winner = switch (result) {
            case PLAYER_ONE_WIN -> game.getPlayer1().getName();
            case PLAYER_TWO_WIN -> game.getPlayer2().getName();
            case TIE -> "Nobody (tie)";
        };
        logger.info("The winner of the game is: {}!", winner);

        Game newgame = new Game(
                new Player("Rigged", new FixedMoveStrategy(Move.ROCK)),
                new Player("Input", new UserInputMoveStrategy()),
                5
        );
        newgame.play();
        result = newgame.getResult();
        winner = switch (result) {
            case PLAYER_ONE_WIN -> newgame.getPlayer1().getName();
            case PLAYER_TWO_WIN -> newgame.getPlayer2().getName();
            case TIE -> "Nobody (tie)";
        };
        logger.info("The winner of the game is: {}!", winner);
    }
}