import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class P04AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vatCalculator = e -> e * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(vatCalculator)
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
