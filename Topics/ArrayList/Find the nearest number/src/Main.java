import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> inputArray = new ArrayList<>();
        ArrayList<Integer> outputArray = new ArrayList<>();
        ArrayList<Integer> differenceArray = new ArrayList<>();

        String[] inputStrings = scanner.nextLine().split(" ");
        int n = scanner.nextInt();

        for (String s : inputStrings) {
            int i = Integer.parseInt(s);
            inputArray.add(i);
            differenceArray.add(Math.abs(n - i));
        }

        Collections.sort(differenceArray);
        int minDifference = differenceArray.get(0);

        for (Integer i : inputArray) {
            if (i == n + minDifference || i == n - minDifference) {
                outputArray.add(i);
            }
        }

        Collections.sort(outputArray);

        for (Integer i : outputArray) {
            System.out.print(i + " ");
        }
    }
}