import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> myStack = new Stack<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commandParameters = input.split("\\s+", 2);
            String commandName = commandParameters[0];
            if (commandName.equals("Push")) {
                int[] elementsToPush = Arrays.stream(commandParameters[1].trim().split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int element : elementsToPush) {
                    myStack.push(element);
                }
            } else {
                try {
                    myStack.pop();
                } catch (IllegalStateException e) {
                    System.out.println("No elements");
                }
            }
            input = scanner.nextLine();
        }

        myStack.forEach(System.out::println);
        myStack.forEach(System.out::println);
    }
}
