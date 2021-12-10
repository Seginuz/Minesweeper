import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String shape = scanner.next();
        double area;

        switch (shape) {
            case "triangle":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double s = (a + b + c) / 2;

                area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                break;
            case "rectangle":
                double d = scanner.nextDouble();
                double e = scanner.nextDouble();

                area = d * e;
                break;
            case "circle":
                double r = scanner.nextDouble();
                double pi = 3.14;

                area = pi * r * r;
                break;
            default:
                area = 0;
                break;
        }

        System.out.println(area);
    }
}