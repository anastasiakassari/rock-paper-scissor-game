package com.anastasiakassari.rps.model;

public enum Move {
    ROCK, PAPER, SCISSORS;

    public boolean beats(Move otherMove) {
        return (this == ROCK && otherMove == SCISSORS) || (this == PAPER && otherMove == ROCK) || (this == SCISSORS && otherMove == PAPER);
    }
}
