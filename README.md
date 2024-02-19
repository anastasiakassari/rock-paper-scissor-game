# Rock-Paper-Scissors Game

## Description

This project implements a simple Rock-Paper-Scissors game where two players compete against each other using different 
strategies. The rules of the game are:
- Scissors beats Paper
- Rock beats Scissors
- Paper beats Rock
- If both players choose the same move, the round is counted as a tie.

The game consists of 100 rounds where Player A always chooses Paper, and Player B chooses a random move.

## Project Structure

The project consists of the following components:
- `com.anastasiakassari.rps.app`: Contains the main application class `RockPaperScissorsApp` responsible for running the 
game.
- `com.anastasiakassari.rps.model`: Contains classes representing the game's model, including players, moves, move 
strategies and the game.
- `com.anastasiakassari.rps.model.game`: Contains classes related to the game logic, including the `Game` class and the 
`GameResult` enum.
- `com.anastasiakassari.rps.model.move`: Contains classes representing different move strategies, including 
`FixedMoveStrategy` and `RandomMoveStrategy`.
- `test`: Contains test classes for unit testing and integration testing various components of the game.

## Building the Project

The project can be built using Gradle by running the appropriate Gradle tasks. To build the project, execute the 
following command:
```
./gradlew build
```

## Running the application

### Running from IDE

To run the game from your IDE, execute the `main` method in the `RockPaperScissorsApp` class.

### Running from Command Line

To run the game from the command line, follow these steps:
1. Build the project using Gradle:
   ```./gradlew build```
2. Run the game using the generated JAR file:
   ```java -jar build/libs/rock-paper-scissors-game-shadow.jar```

## Testing

The project includes a test suite covering various aspects of the game logic and player behavior, using JUnit5. There are
both unit tests for testing various components of the game, including players, moves, move strategies and integration tests 
to ensure that the game behaves correctly under different scenarios.

## Dependencies

The project uses the following dependencies:
- SLF4J and Logback for logging
- Mockito and JUnit Jupiter for testing

## Advantages & Disadvantages

## Advantages

- **Modularity**: The project is structured in a modular way, making it easy to understand and maintain.
- **Test Coverage**: There are unit tests and integration tests to ensure the correctness of the game logic and player 
behavior.
- **Flexibility**: The design allows for easy extension and customization of player's move strategies and game rules.
  (e.g. a strategy with user input, weighted or adaptive move strategies)
- **Scalability**: The game architecture can accommodate future enhancements and additional features without significant 
refactoring.
- **Separation of Concerns**: Each component of the game has a well-defined responsibility, improving code 
readability and maintainability.
- **Lightweight & Efficient**: The absence of a Spring framework, such as Spring Boot, reduces overhead and makes the 
application more lightweight, leading to faster startup times and reduced resource consumption. 

## Disadvantages

- **Fixed Player Strategies**: The game only supports fixed player strategies.
- **Limited Player Interaction**: The game does not provide options for human players to interact directly.
- **Complexity**: As the project grows, managing interactions between various components may become more complex.
