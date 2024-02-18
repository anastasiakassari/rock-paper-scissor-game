package com.anastasiakassari.rps.model.move;

import java.util.Scanner;

public class UserInputMoveStrategy implements MoveStrategy {
    private final Scanner scanner;

    public UserInputMoveStrategy() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move makeMove() {
        // Display prompt for user input
        System.out.println("Enter your move (Rock, Paper, or Scissors):");

        // Read user input
        String userInput = scanner.nextLine().trim().toUpperCase();

        // Validate and convert user input to Move enum
        try {
            return Move.valueOf(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input! Please enter Rock, Paper, or Scissors.");
            // Recursive call to retry input
            return makeMove();
        }
    }
}
