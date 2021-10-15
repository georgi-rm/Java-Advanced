import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> evenNumbers = numbers
                .stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());

        String firstOutputLine = evenNumbers
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(firstOutputLine);

        String secondOutputLine = evenNumbers
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(secondOutputLine);
    }
}
