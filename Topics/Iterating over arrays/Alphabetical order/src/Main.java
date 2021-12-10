import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        boolean isAlphabetical = true;
        for (int j = 0; j < inputArray.length - 1; j++) {
            if (inputArray[j].compareTo(inputArray[j + 1]) > 0) {
                isAlphabetical = false;
                break;
            }
        }

        System.out.println(isAlphabetical);
    }
}