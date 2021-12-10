package minesweeper;

import java.util.Random;

public class Minefield {
    private final Cell[][] field;
    private final int fieldWidth;
    private final int fieldHeight;
    private final int mineAmount;
    private int markedCellAmount = 0;
    private boolean firstMove = true;
    private boolean gameFailed = false;

    public Minefield(int fieldWidth, int fieldHeight, int mineAmount) {
        this.field = new Cell[fieldHeight][fieldWidth];
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;

        // If the entered amount of mines exceeds the amount of mines possible,
        // set the amount of mines to the maximum possible value to prevent a hang when generating the mines
        this.mineAmount = Math.min(mineAmount, this.fieldHeight * this.fieldWidth);

        // Fill the field with empty cells, generate mine positions and generate the numbers around the mines
        fillField();
        generateMines();
        generateNumbers();
    }

    // Fills the field with empty cells.
    private void fillField() {
        for (int i = 0; i < this.fieldHeight; i++) {
            for (int j = 0; j < this.fieldWidth; j++) {
                this.field[i][j] = new Cell();
            }
        }
    }

    // Generates a set amount of randomly placed mines in the minefield.
    private void generateMines() {
        final Random random = new Random();

        for (int i = 0; i < this.mineAmount; i++) {
            int x = random.nextInt(this.fieldWidth);
            int y = random.nextInt(this.fieldHeight);

            if (!this.field[y][x].isMine()) {
                this.field[y][x].setMine(true);
            } else {
                i--;
            }
        }
    }

    // Generates the numbers for empty cells with mines around them.
    private void generateNumbers() {
        // Loop through all cells
        for (int y = 0; y < this.field.length; y++) {
            for (int x = 0; x < this.field[y].length; x++) {
                // Start looking for mines around this cell if it is not a mine itself
                if (!this.field[y][x].isMine()) {
                    int maxX = this.field[y].length - 1;
                    int maxY = this.field.length - 1;

                    // Loop through all cells around the current cell
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int offsetX = x + j;
                            int offsetY = y + i;

                            // If the cell to check is within the bounds of the minefield, and it contains a mine,
                            // add one to the minesAround counter of the cell
                            if (!(offsetX < 0) && !(offsetY < 0) && !(offsetX > maxX) && !(offsetY > maxY)) {
                                if (this.field[offsetY][offsetX].isMine()) {
                                    this.field[y][x].setMinesAround(this.field[y][x].getMinesAround() + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // Prints the entire minefield to the console with some additional styling.
    public void showField() {
        System.out.print(" |");
        for (int i = 1; i <= fieldWidth; i++) {
            System.out.print(i);
        }
        System.out.println("|");

        System.out.print("-|");
        for (int i = 1; i <= fieldWidth; i++) {
            System.out.print("-");
        }
        System.out.println("|");

        for (int i = 0; i < fieldHeight; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldWidth; j++) {
                Cell cell = this.field[i][j];

                if (cell.isMarked()) {
                    System.out.print('*');
                } else {
                    if (!cell.isExplored()) {
                        System.out.print(".");
                    } else {
                        if (cell.isMine()) {
                            System.out.print('X');
                        } else {
                            if (cell.getMinesAround() == 0) {
                                System.out.print('/');
                            } else {
                                System.out.print(cell.getMinesAround());
                            }
                        }
                    }
                }
            }
            System.out.println("|");
        }

        System.out.print("-|");
        for (int i = 1; i <= fieldWidth; i++) {
            System.out.print("-");
        }
        System.out.println("|");
    }

    // Explores a cell if it is not already explored
    // Recursively explores all cells around the explored cell if it does not contain a number
    // If an exploration move lands on a mine, it's game over
    public boolean exploreCell(int markX, int markY) {
        if (markX < 0 || markX > fieldWidth - 1) {
            return false;
        }
        if (markY < 0 || markY > fieldHeight - 1) {
            return false;
        }

        Cell cell = field[markY][markX];

        // Regenerate the minefield if the first move doesn't land on an empty cell
        if (this.firstMove && this.mineAmount > (fieldHeight * fieldWidth)) {
            this.firstMove = false;

            while(cell.getMinesAround() != 0 || cell.isMine()) {
                for (int i = 0; i < fieldHeight; i++) {
                    for (int j = 0; j < fieldWidth; j++) {
                        field[i][j].setMine(false);
                        field[i][j].setMinesAround(0);
                    }
                }

                generateMines();
                generateNumbers();
            }
        }

        // Explore the cell if it is not already explored
        if (!cell.isExplored()) {
            cell.setExplored();

            // Fail the game if the explored cell is a mine
            if (!cell.isMine()) {
                // Unmark any marked cells that get explored
                cell.setMarked(false);

                // Recursively explore empty cells around the current cell if there aren't any mines around it
                if (cell.getMinesAround() == 0) {
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            exploreCell(markX + i, markY + j);
                        }
                    }
                }
            } else {
                this.gameFailed = true;
            }
        }

        return true;
    }

    // Marks or unmarks a cell as a mine if it does not have any mines around it.
    // Returns true if a cell was marked/unmarked, otherwise returns false.
    public boolean markCell(int markX, int markY) {
        if (markX < 0 || markX > fieldWidth - 1) {
            return false;
        }
        if (markY < 0 || markY > fieldHeight - 1) {
            return false;
        }

        Cell cell = field[markY][markX];

        if (!cell.isExplored()) {
            if (!cell.isMarked()) {
                cell.setMarked(true);
                this.markedCellAmount++;
            } else {
                cell.setMarked(false);
                this.markedCellAmount--;
            }
        } else {
            System.out.println("This cell has already been explored!");
            return false;
        }
        return true;
    }

    // If the amount of mines matches the amount of marked cells,
    // checks if all cells that have been marked contain a mine.
    // Returns true if the game has been completed, and false if it hasn't.
    public boolean checkGameComplete() {
        if (this.gameFailed) {
            return true;
        }

        boolean allMinesMarked = true;
        boolean allSafeCellsOpened = true;

        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldWidth; j++) {
                if (field[i][j].isMarked() && !field[i][j].isMine()) {
                    allMinesMarked = false;
                }
                if (!field[i][j].isExplored() && !field[i][j].isMine()) {
                    allSafeCellsOpened = false;
                }
            }
        }

        if (this.mineAmount != this.markedCellAmount) {
            allMinesMarked = false;
        }

        return allMinesMarked || allSafeCellsOpened;
    }

    public boolean isGameFailed() {
        return gameFailed;
    }
}
