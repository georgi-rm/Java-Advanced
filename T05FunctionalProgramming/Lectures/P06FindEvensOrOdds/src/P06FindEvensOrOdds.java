import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bounds = scanner.nextLine().split("\\s+");
        int startNumber = Integer.parseInt(bounds[0]);
        int endNumber = Integer.parseInt(bounds[1]);
        String type = scanner.nextLine();

        Predicate<Integer> filterCondition = type.equals("even")
                    ? e -> e % 2 == 0
                    : e -> e % 2 != 0;

        printNumbersInRange(startNumber, endNumber, filterCondition);
    }

    public static void printNumbersInRange(int startNumber, int endNumber, Predicate<Integer> filterCondition) {
        System.out.println(IntStream.rangeClosed(startNumber, endNumber)
                .boxed()
                .filter(filterCondition)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
