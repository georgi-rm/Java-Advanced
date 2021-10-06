import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] realNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> countOfRealNumbers = new LinkedHashMap<>();

        for (double realNumber : realNumbers) {
            countOfRealNumbers.putIfAbsent(realNumber, 0);
            int numberOfOccurrences = countOfRealNumbers.get(realNumber);
            numberOfOccurrences++;
            countOfRealNumbers.put(realNumber, numberOfOccurrences);
        }

        countOfRealNumbers.forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
