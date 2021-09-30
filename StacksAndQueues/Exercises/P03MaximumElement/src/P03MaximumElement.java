import java.util.ArrayDeque;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandData = scanner.nextLine().split("\\s+");
            int commandNumber = Integer.parseInt(commandData[0]);

            switch (commandNumber) {
                case 1:
                    int newElement = Integer.parseInt(commandData[1]);
                    stack.push(newElement);
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case 3:
                    if (!stack.isEmpty()) {
                        int maxElement = stack.stream().mapToInt(Integer::intValue).max().orElse(0);
                        System.out.println(maxElement);
                    }
                    break;
            }
        }
    }
}
