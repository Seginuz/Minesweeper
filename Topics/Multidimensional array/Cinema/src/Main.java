import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstDim = scanner.nextInt();
        int secondDim = scanner.nextInt();
        int[][] cinemaSeats = new int[firstDim][secondDim];

        for (int i = 0; i < cinemaSeats.length; i++) {
            for (int j = 0; j < cinemaSeats[i].length; j++) {
                cinemaSeats[i][j] = scanner.nextInt();
            }
        }

        int seatsNeeded = scanner.nextInt();
        int rowWithSeats = 0;

        for (int i = 0; i < cinemaSeats.length; i++) {
            int availableSeats = 0;

            for (int j = 0; j < cinemaSeats[i].length; j++) {
                if (cinemaSeats[i][j] == 0) {
                    availableSeats++;

                    if (availableSeats == seatsNeeded) {
                        rowWithSeats = i + 1;
                        break;
                    }
                } else {
                    availableSeats = 0;
                }
            }

            if (rowWithSeats > 0) {
                break;
            }
        }

        System.out.println(rowWithSeats);
    }
}