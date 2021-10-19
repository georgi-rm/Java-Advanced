import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findIndexOfSmallestNumber = (list) -> {
            int smallestNumber = list.get(0);
            int indexOfSmallestNumber = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= smallestNumber) {
                    smallestNumber = list.get(i);
                    indexOfSmallestNumber = i;
                }
            }
            return indexOfSmallestNumber;
        };

        System.out.println(findIndexOfSmallestNumber.apply(listOfNumbers));
    }
}
