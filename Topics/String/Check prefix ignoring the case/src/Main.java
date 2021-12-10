import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();

        input = input.toLowerCase();

        boolean startsWithJ = input.startsWith("j");

        System.out.println(startsWithJ);
    }
}