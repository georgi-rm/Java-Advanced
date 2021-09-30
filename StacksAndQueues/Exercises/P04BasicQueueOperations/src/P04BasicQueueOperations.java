import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputVariables = scanner.nextLine().split("\\s+");
        int numberOfElementsToAdd = Integer.parseInt(inputVariables[0]);
        int numberOfTimesToPoll = Integer.parseInt(inputVariables[1]);
        int numberToSearch = Integer.parseInt(inputVariables[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(numberOfElementsToAdd)
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

        while (numberOfTimesToPoll > 0) {
            if (queue.isEmpty()) {
                break;
            }
            numberOfTimesToPoll--;
            queue.poll();
        }

        if (queue.contains(numberToSearch)) {
            System.out.println(true);
        } else {
            int minValueFromQueue = Integer.MAX_VALUE;
            if (queue.isEmpty()) {
                minValueFromQueue = 0;
            } else {
                while (!queue.isEmpty()) {
                    int currentValue = queue.poll();
                    if (currentValue < minValueFromQueue) {
                        minValueFromQueue = currentValue;
                    }
                }
            }
            System.out.println(minValueFromQueue);
        }

    }
}
