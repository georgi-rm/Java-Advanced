import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Comparator<Integer> evenOddComparator = (e1, e2) -> {
            if (isEven(e1) && !isEven(e2)) {
                return -1;
            } else if (!isEven(e1) && isEven(e2)) {
                return 1;
            }
            return Integer.compare(e1, e2);
        };

        Arrays.sort(numbers, evenOddComparator);
        for (Integer number : numbers) {
            System.out.printf("%d ", number);
        }
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
