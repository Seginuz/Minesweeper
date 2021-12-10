package minesweeper;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        int fieldWidth = 9;
        int fieldHeight = 9;

        System.out.println("How many mines do you want on the field?");
        int mineAmount = scanner.nextInt();

        Minefield minefield = new Minefield(fieldWidth, fieldHeight, mineAmount);

        // The main game loop, it keeps looping as long as the game has not been completed
        boolean gameComplete = false;
        while (!gameComplete) {
            minefield.showField();

            // Ask the player to make a move, and ask again if the player made a wrong move
            // I wanted to use a do-while loop here just because I felt like it
            boolean successfulMove;
            do {
                System.out.println("Set/unset mine marks or claim a cell as free:");
                int markX = scanner.nextInt() - 1;
                int markY = scanner.nextInt() - 1;
                String command = scanner.next();

                if ("free".equals(command)) {
                    successfulMove = minefield.exploreCell(markX, markY);
                } else {
                    successfulMove = minefield.markCell(markX, markY);
                }
            } while (!successfulMove);

            // Check if the game has been completed
            gameComplete = minefield.checkGameComplete();
        }

        minefield.showField();
        if (!minefield.isGameFailed()) {
            System.out.println("Congratulations! You found all the mines!");
        } else {
            System.out.println("You stepped on a mine and failed!");
        }
    }
}
