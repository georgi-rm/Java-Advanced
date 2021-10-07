import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        int numberOfRecords = Integer.parseInt(scanner.nextLine());

        for (int record = 0; record < numberOfRecords; record++) {
            String[] recordData = scanner.nextLine().split("\\s+");
            String continentName = recordData[0];
            String countryName = recordData[1];
            String cityName = recordData[2];

            continents.putIfAbsent(continentName, new LinkedHashMap<>());
            Map<String, List<String>> country = continents.get(continentName);
            country.putIfAbsent(countryName, new ArrayList<>());
            List<String> listWithCities = country.get(countryName);
            listWithCities.add(cityName);

            country.put(countryName, listWithCities);
            continents.put(continentName, country);
        }

        continents.forEach((continentKey, continentValue) -> {
            System.out.printf("%s:%n", continentKey);
            continentValue.forEach((key, value) -> {
                System.out.printf("  %s -> ", key);
                String allCities = String.join(", ", value);
                System.out.println(allCities);
            });

        });
    }
}
