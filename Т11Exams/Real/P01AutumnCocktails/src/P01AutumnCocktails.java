import java.util.*;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> cocktailsDone = new TreeMap<>();

        cocktailsDone.put("Pear Sour", 0);
        cocktailsDone.put("The Harvest", 0);
        cocktailsDone.put("Apple Hinny", 0);
        cocktailsDone.put("High Fashion", 0);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessLevels = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(freshnessLevels::push);

        while (!ingredients.isEmpty() && !freshnessLevels.isEmpty()) {
            int ingredient = extractIngredient(ingredients);
            if (ingredient == 0) {
                break;
            }

            int freshnessLevel = freshnessLevels.pop();

            int cocktailValue = ingredient * freshnessLevel;

            switch (cocktailValue) {
                case 150:
                    incrementCocktailByName("Pear Sour", cocktailsDone);
                    break;
                case 250:
                    incrementCocktailByName("The Harvest", cocktailsDone);
                    break;
                case 300:
                    incrementCocktailByName("Apple Hinny", cocktailsDone);
                    break;
                case 400:
                    incrementCocktailByName("High Fashion", cocktailsDone);
                    break;
                default:
                    ingredient += 5;
                    ingredients.offer(ingredient);
                    break;
            }
        }

        if (areAllCocktailsDone(cocktailsDone)) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()) {
            int sumOfIngredients = ingredients.stream()
                    .mapToInt(e -> e)
                    .sum();
            System.out.printf("Ingredients left: %d%n", sumOfIngredients);
        }

        for (Map.Entry<String, Integer> cocktail : cocktailsDone.entrySet()) {
            if (cocktail.getValue() != 0) {
                System.out.printf(" # %s --> %d%n", cocktail.getKey(), cocktail.getValue());
            }
        }

    }

    private static boolean areAllCocktailsDone(Map<String, Integer> cocktailsDone) {
        for (Integer count : cocktailsDone.values()) {
            if (count == 0) {
                return false;
            }
        }
        return true;
    }

    private static int extractIngredient(ArrayDeque<Integer> ingredients) {
        int ingredient = 0;
        while (ingredient == 0) {
            if (ingredients.isEmpty()) {
                return 0;
            }
            ingredient = ingredients.poll();
        }
        return ingredient;
    }

    private static void incrementCocktailByName(String cocktailName, Map<String, Integer> cocktailsDone) {
        int currentNumberOfCocktail = cocktailsDone.get(cocktailName);
        currentNumberOfCocktail++;
        cocktailsDone.put(cocktailName, currentNumberOfCocktail);
    }

}
