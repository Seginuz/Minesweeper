import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        int count = 0;

        for (int i = 1; i <= input; i++) {
            for (int k = i; k != 0; k--) {
                if (count >= input) {
                    break;
                }
                System.out.print(i + " ");
                count++;
            }
        }
    }
}