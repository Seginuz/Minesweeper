package minesweeper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// This class contains my old (non-OO) version of minesweeper using ArrayLists
public class Main_Old {
    public static ArrayList<ArrayList<Character>> createMineField(int fieldHeight, int fieldWidth) {
        ArrayList<ArrayList<Character>> mineField = new ArrayList<>(fieldHeight);

        for (int i = 0; i < fieldHeight; i++) {
            ArrayList<Character> row = new ArrayList<>(fieldWidth);

            for (int j = 0; j < fieldWidth; j++) {
                row.add('.');
            }
            mineField.add(row);
        }

        return mineField;
    }

    public static void generateMines(ArrayList<ArrayList<Character>> mineField, int mineAmount) {
        Random random = new Random();

        for (int i = 0; i < mineAmount; i++) {
            int x = random.nextInt(mineField.get(1).size());
            int y = random.nextInt(mineField.size());

            if (mineField.get(y).get(x) != 'X') {
                mineField.get(y).set(x, 'X');
            } else {
                i--;
            }
        }
    }

    public static void generateNumbers(ArrayList<ArrayList<Character>> mineField) {
        for (int y = 0; y < mineField.size(); y++) {
            for (int x = 0; x < mineField.get(y).size(); x++) {
                if (mineField.get(y).get(x) == '.') {
                    mineField.get(y).set(x, getMinesAroundCell(mineField, x, y));
                }
            }
        }
    }

    public static char getMinesAroundCell(ArrayList<ArrayList<Character>> mineField, int x, int y) {
        char minesAroundCell = '0';
        int maxX = mineField.get(y).size() - 1;
        int maxY = mineField.size() - 1;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((x + j >= 0 && y + i >= 0 && x + j <= maxX && y + i <= maxY)
                        && (mineField.get(y + i).get(x + j) == 'X')) {
                    minesAroundCell++;
                }
            }
        }

        return (minesAroundCell != '0') ? minesAroundCell : '.';
    }

    public static void showMineField(ArrayList<ArrayList<Character>> mineField) {
        for (ArrayList<Character> row : mineField) {
            for (Character cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public static void mainOld(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        System.out.println("What width do you want the field to be?");
//        int fieldWidth = scanner.nextInt();
        int fieldWidth = 9;

//        System.out.println("What height do you want the field to be?");
//        int fieldHeight = scanner.nextInt();
        int fieldHeight = 9;

        ArrayList<ArrayList<Character>> mineField = createMineField(fieldHeight, fieldWidth);

        System.out.println("How many mines do you want on the field?");
        int mineAmount = scanner.nextInt();

        generateMines(mineField, mineAmount);
        generateNumbers(mineField);
        showMineField(mineField);
    }
}
