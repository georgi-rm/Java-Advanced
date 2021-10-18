import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] allNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Integer[] numbers = new Integer[allNumbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = allNumbers[i];
        }

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    doArithmeticOperation(numbers, e -> e + 1);
                    break;
                case "subtract":
                    doArithmeticOperation(numbers, e -> e - 1);
                    break;
                case "multiply":
                    doArithmeticOperation(numbers, e -> e * 2);
                    break;
                case "print":
                    Arrays.stream(numbers).forEach(e -> System.out.printf("%d ", e));
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static void doArithmeticOperation(Integer[] numbers, UnaryOperator<Integer> action) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = action.apply(numbers[i]);
        }
    }
}
