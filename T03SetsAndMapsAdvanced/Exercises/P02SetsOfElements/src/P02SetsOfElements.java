import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        int numberOfElementsInFirstSet = scanner.nextInt();
        int numberOfElementsInSecondSet = scanner.nextInt();

        for (int i = 0; i < numberOfElementsInFirstSet; i++) {
            firstSet.add(scanner.nextInt());
        }

        for (int i = 0; i < numberOfElementsInSecondSet; i++) {
            secondSet.add(scanner.nextInt());
        }

        for (Integer number : firstSet) {
            if (!secondSet.add(number)) {
                System.out.printf("%d ", number);
            }
        }
    }
}
