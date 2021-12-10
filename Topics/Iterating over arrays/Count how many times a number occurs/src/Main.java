import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            array[i] = scanner.nextInt();
        }

        int checkFor = scanner.nextInt();
        int count = 0;
        for (int i : array) {
            if (i == checkFor) {
                count++;
            }
        }

        System.out.println(count);
    }
}