import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();

        input1 = input1.replace(" ", "");
        input2 = input2.replace(" ", "");

        boolean compare = input1.equals(input2);

        System.out.println(compare);
    }
}