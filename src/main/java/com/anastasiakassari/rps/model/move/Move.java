package com.anastasiakassari.rps.model.move;

/**
 * Represents the possible moves in a Rock, Paper, Scissors game.
 */
public enum Move {
    ROCK, PAPER, SCISSORS;

    /**
     * Determines if this move beats the opponent's move.
     * @param  otherMove   the opponent's move to compare against
     * @return             true if this move beats the opponent's move and false otherwise
     */
    public boolean beats(Move otherMove) {
        return (this == ROCK && otherMove == SCISSORS) || (this == PAPER && otherMove == ROCK) || (this == SCISSORS && otherMove == PAPER);
    }
}
