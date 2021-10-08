import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (resources.containsKey(input)) {
                quantity += resources.get(input);
            }

            resources.put(input, quantity);

            input = scanner.nextLine();
        }

        resources.forEach((resource, quantity) -> System.out.printf("%s -> %d%n", resource, quantity));
    }
}
