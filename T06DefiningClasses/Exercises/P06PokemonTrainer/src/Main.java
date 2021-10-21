import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] commandParameters = input.split("\\s+");
            String trainerName = commandParameters[0];
            String pokemonName = commandParameters[1];
            String pokemonElement = commandParameters[2];
            int pokemonHealth = Integer.parseInt(commandParameters[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            Trainer trainer = trainers.get(trainerName);
            trainer.addPokemon(pokemon);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {
            for (Trainer trainer : trainers.values()) {
                trainer.elementUse(input);
            }

            input = scanner.nextLine();
        }

        trainers.values().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getNumberOfBadges(), t1.getNumberOfBadges()))
                .forEach(System.out::println);
    }
}
