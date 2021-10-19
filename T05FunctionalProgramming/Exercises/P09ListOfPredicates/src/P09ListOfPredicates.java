import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class P09ListOfPredicates {
    public static BiPredicate<Integer, Integer> isDivisionPossible = (f, s) -> f % s == 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Integer> dividers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        for (int number = 1; number <= n; number++) {
            boolean isValid = true;
            for (Integer divider : dividers) {
                if (!isDivisionPossible.test(number, divider)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                System.out.printf("%d ", number);
            }
        }
    }
}
