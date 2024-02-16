package com.anastasiakassari.rps.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    final List<Move> moves;

    @NotBlank(message = "Name cannot be blank")
    final String name;

    Player(String name, @Positive(message = "Number of rounds must be positive") int rounds) {
        this.name = name;
        this.moves = new ArrayList<>(rounds);
    }

    public String getName() {
        return name;
    }

    public Move getMove(int round) {
        return moves.get(round);
    }
}

