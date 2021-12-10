import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cityName = scanner.nextLine();

        System.out.println(cityName.endsWith("burg"));
    }
}