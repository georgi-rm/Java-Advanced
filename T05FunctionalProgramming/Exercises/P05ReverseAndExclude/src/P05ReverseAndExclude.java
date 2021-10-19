import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
        .map(Integer::parseInt)
        .collect(Collectors.toList());

        int divider = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isDivisible = e -> e % divider != 0;

        Collections.reverse(numbers);

        numbers.stream()
                .filter(isDivisible)
                .forEach(e -> System.out.printf("%d ", e));
    }
}
