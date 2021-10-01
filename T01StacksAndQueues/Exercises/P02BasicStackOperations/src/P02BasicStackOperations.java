import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputVariables = scanner.nextLine().split("\\s+");
        int numberOfElementsToPush = Integer.parseInt(inputVariables[0]);
        int numberOfTimesToPop = Integer.parseInt(inputVariables[1]);
        int numberToSearch = Integer.parseInt(inputVariables[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(numberOfElementsToPush)
                .mapToInt(Integer::parseInt)
                .forEach(stack::push);

        while (numberOfTimesToPop > 0) {
            if (stack.isEmpty()) {
                break;
            }
            numberOfTimesToPop--;
            stack.pop();
        }

        if (stack.contains(numberToSearch)) {
            System.out.println(true);
        } else {
            int minValueFromStack = Integer.MAX_VALUE;
            if (stack.isEmpty()) {
                minValueFromStack = 0;
            } else {
                while (!stack.isEmpty()) {
                    int currentValue = stack.pop();
                    if (currentValue < minValueFromStack) {
                        minValueFromStack = currentValue;
                    }
                }
            }
            System.out.println(minValueFromStack);
        }

    }
}
