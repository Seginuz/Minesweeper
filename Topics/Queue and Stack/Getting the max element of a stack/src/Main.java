import java.util.ArrayDeque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        MaxStack maxStack = new MaxStack();

        int commands = scanner.nextInt();

        for (int i = 0; i < commands; i++) {
            switch (scanner.next()) {
                case "push":
                    maxStack.push(scanner.nextInt());
                    break;
                case "pop":
                    maxStack.pop();
                    break;
                case "max":
                    maxStack.max();
                    break;
                default:
                    break;
            }
        }
    }
}

class MaxStack {
    private final ArrayDeque<Integer> stack = new ArrayDeque<>();
    private final ArrayDeque<Integer> maxNums = new ArrayDeque<>();

    public void push(int v) {
        stack.addLast(v);

        if (maxNums.isEmpty()) {
            maxNums.addLast(v);
        } else if (v >= maxNums.peekLast()) {
            maxNums.addLast(v);
        }
    }

    public void pop() {
        int v = stack.pollLast();

        if (v == maxNums.peekLast()) {
            maxNums.pollLast();
        }
    }

    public void max() {
        System.out.println(maxNums.peekLast());
    }
}