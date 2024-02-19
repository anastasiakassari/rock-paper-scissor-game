package com.anastasiakassari.rps.model;

import com.anastasiakassari.rps.model.move.Move;
import com.anastasiakassari.rps.model.move.MoveStrategy;

/**
 * Represents a player in a game.
 */
public class Player {

    MoveStrategy moveStrategy;
    final String name;

    /**
     * Constructs a player with the given name and move strategy.
     * @param name         the name of the player
     * @param moveStrategy the move strategy of the player
     */
    public Player(String name, MoveStrategy moveStrategy) {

        // Ensure that the name is not null
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }

        // Ensure that the move strategy is not null
        if (moveStrategy == null) {
            throw new IllegalArgumentException("Move strategy cannot be null.");
        }

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

    /**
     * Overrides the equals method to compare Player objects.     *
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name) && moveStrategy.equals(player.moveStrategy);
    }
}

