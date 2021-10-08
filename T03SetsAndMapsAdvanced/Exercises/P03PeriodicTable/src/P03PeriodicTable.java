import java.util.*;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> chemicalElements = new TreeSet<>();
        int numberOfCompounds = Integer.parseInt(scanner.nextLine());

        for (int lines = 0; lines < numberOfCompounds; lines++) {
            Arrays.stream(scanner.nextLine().split("\\s+")).forEach(chemicalElements::add);
        }

        for (String chemicalElement : chemicalElements) {
            System.out.printf("%s ", chemicalElement);
        }
    }
}
