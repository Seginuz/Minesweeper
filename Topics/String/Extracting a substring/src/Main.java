import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String inputString = scanner.nextLine();
        int lowerBound = scanner.nextInt();
        int upperBound = scanner.nextInt();

        System.out.println(inputString.substring(lowerBound, upperBound + 1));
    }
}