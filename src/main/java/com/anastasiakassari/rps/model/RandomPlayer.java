package com.anastasiakassari.rps.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Arrays;

public class RandomPlayer extends Player {

    public RandomPlayer(String name, @Positive(message = "Number of rounds must be positive") int rounds, @NotNull(message = "Moves cannot be null" ) Move... moves) {

        super(name, rounds);
        // Ensure that the number of moves matches the number of rounds
        if (moves.length != rounds) {
            throw new IllegalArgumentException("Number of moves must match the number of rounds.");
        }
        this.moves.addAll(Arrays.asList(moves).subList(0, rounds));
    }

}
