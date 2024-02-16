package com.anastasiakassari.rps.app;

import com.anastasiakassari.rps.model.Game;
import com.anastasiakassari.rps.model.Move;
import com.anastasiakassari.rps.model.RandomPlayer;
import com.anastasiakassari.rps.model.SingleMovePlayer;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RockPaperScissorsApp {
    public static void main(String[] args) {

        int rounds = 100;
        Random random = new Random();

        List<Move> movesList = IntStream.range(0, rounds)
                .mapToObj(i -> Move.values()[random.nextInt(Move.values().length)])
                .toList();

        Game game = new Game(
                new SingleMovePlayer("A", rounds, Move.ROCK),
                new RandomPlayer("B", rounds, movesList.toArray(new Move[rounds])),
                rounds
        );
        game.winner();

    }
}