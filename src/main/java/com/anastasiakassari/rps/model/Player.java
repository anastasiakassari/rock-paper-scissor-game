package com.anastasiakassari.rps.model;

import com.anastasiakassari.rps.model.move.Move;
import com.anastasiakassari.rps.model.move.MoveStrategy;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Represents a player in a game.
 */
public class Player {
    @NotNull(message = "Moves cannot be null")
    MoveStrategy moveStrategy;

    @NotBlank(message = "Name cannot be blank")
    final String name;

    /**
     * Constructs a player with the given name and move strategy.
     * @param name         the name of the player
     * @param moveStrategy the move strategy of the player
     */
    public Player(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    /**
     * Get the name of the player.
     * @return The player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Makes a move using the move strategy.
     * @return the move to be made
     */
    public Move makeMove() {
        return moveStrategy.makeMove();
    }
}

