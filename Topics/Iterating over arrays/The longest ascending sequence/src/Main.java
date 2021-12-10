import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();
        int[] inputArray = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            inputArray[i] = scanner.nextInt();
        }

        int longestSequence = 1;
        int currentSequence = 1;

        for (int j = 1; j < arrayLength; j++) {
            if (inputArray[j] > inputArray[j - 1]) {
                currentSequence++;
            } else {
                currentSequence = 1;
            }

            if (currentSequence > longestSequence) {
                longestSequence = currentSequence;
            }
        }

        System.out.println(longestSequence);
    }
}