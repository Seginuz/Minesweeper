import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int[] inputArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = scanner.nextInt();
        }

        int triples = 0;
        for (int i = 0; i < arraySize - 2; i++) {
            if (inputArray[i] == inputArray[i + 1] - 1 && inputArray[i + 1] == inputArray[i + 2] - 1) {
                triples++;
            }
        }

        System.out.println(triples);
    }
}