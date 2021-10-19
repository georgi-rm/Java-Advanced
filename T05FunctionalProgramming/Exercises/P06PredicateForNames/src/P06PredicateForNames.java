import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nameLengthLimit = Integer.parseInt(scanner.nextLine());

        String[] namesArray = scanner.nextLine().split("\\s+");

        Predicate<String> filterByLimit = e -> e.length() <= nameLengthLimit;

        Arrays.stream(namesArray)
                .filter(filterByLimit)
                .forEach(System.out::println);
    }
}
