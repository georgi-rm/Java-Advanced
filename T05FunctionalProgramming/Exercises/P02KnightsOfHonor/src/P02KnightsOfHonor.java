import java.util.Scanner;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String> printName = name -> System.out.printf("Sir %s%n", name);

        for (String name : names) {
            printName.accept(name);
        }
    }
}
