import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Function<String, Integer> countNumbersFromString = str -> input.split(", ").length;
        Function<String, Integer> sumNumbersFromString = str -> Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .sum();

        int countOfNumbers = countNumbersFromString.apply(input);
        int sumOfNumbers = sumNumbersFromString.apply(input);

        System.out.printf("Count = %d%n", countOfNumbers);
        System.out.printf("Sum = %d", sumOfNumbers);
    }
}
