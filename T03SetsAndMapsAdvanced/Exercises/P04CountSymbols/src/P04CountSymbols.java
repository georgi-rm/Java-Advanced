import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character,Integer> characterOccurrences = new TreeMap<>();

        String text = scanner.nextLine();
        for (int i = 0; i < text.length(); i++) {
            Character symbol = text.charAt(i);
            int occurrence = 1;

            if (characterOccurrences.containsKey(symbol)) {
                occurrence += characterOccurrences.get(symbol);
            }
            characterOccurrences.put(symbol, occurrence);
        }

        for (Map.Entry<Character, Integer> entry : characterOccurrences.entrySet()) {
            System.out.printf("%c: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
