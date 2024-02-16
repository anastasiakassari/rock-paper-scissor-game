package com.anastasiakassari.rps.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class SingleMovePlayer extends Player {

    public SingleMovePlayer(String name, @Positive(message = "Number of rounds must be positive") int rounds, @NotNull(message = "Moves cannot be null") Move move) {
        super(name, rounds);
        for (int i = 0; i < rounds; i++) {
            this.moves.add(move);
        }
    }
}
