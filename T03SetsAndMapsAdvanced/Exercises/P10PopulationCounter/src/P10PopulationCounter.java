import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("report")) {
            String[] inputData = input.split("\\|+");
            String city = inputData[0];
            String country = inputData[1];
            long population = Long.parseLong(inputData[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            Map<String, Long> cities = countries.get(country);
            cities.put(city, population);

            input = scanner.nextLine();
        }

        countries.entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(countPopulation(e2.getValue()), countPopulation(e1.getValue())))
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)%n", e.getKey(), countPopulation(e.getValue()));
                    e.getValue().entrySet()
                            .stream()
                            .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                            .forEach(entry -> System.out.printf("=>%s: %d%n", entry.getKey(), entry.getValue()));
                });
    }

    private static long countPopulation(Map<String, Long> city) {
        return city.entrySet()
                .stream()
                .mapToLong(Map.Entry::getValue)
                .sum();
    }

}
