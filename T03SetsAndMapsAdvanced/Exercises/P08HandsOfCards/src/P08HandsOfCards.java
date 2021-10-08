import java.util.*;

public class P08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> cardDecks = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String[] inputData = input.split(": ");
            String name = inputData[0];
            String[] newDrownCards = inputData[1].split(", ");

            if (!cardDecks.containsKey(name)) {
                cardDecks.put(name, new LinkedHashSet<>());
            }

            Set<String> currentDeck = cardDecks.get(name);
            Collections.addAll(currentDeck, newDrownCards);
            cardDecks.put(name, currentDeck);

            input = scanner.nextLine();
        }

        cardDecks.forEach((name, deck) -> {
            int sumOfCards = deck.stream().mapToInt(P08HandsOfCards::getPowerOfCard).sum();
            System.out.printf("%s: %d%n", name, sumOfCards);
        });
    }

    private static int getPowerOfCard(String card) {
        Map<String, Integer> mapOfCardPoints = new HashMap<>();
        mapOfCardPoints.put( "2", 2 );
        mapOfCardPoints.put( "3", 3 );
        mapOfCardPoints.put( "4", 4 );
        mapOfCardPoints.put( "5", 5 );
        mapOfCardPoints.put( "6", 6 );
        mapOfCardPoints.put( "7", 7 );
        mapOfCardPoints.put( "8", 8 );
        mapOfCardPoints.put( "9", 9 );
        mapOfCardPoints.put( "10", 10 );
        mapOfCardPoints.put( "J", 11 );
        mapOfCardPoints.put( "Q", 12 );
        mapOfCardPoints.put( "K", 13 );
        mapOfCardPoints.put( "A", 14 );
        mapOfCardPoints.put( "C", 1 );
        mapOfCardPoints.put( "D", 2 );
        mapOfCardPoints.put( "H", 3 );
        mapOfCardPoints.put( "S", 4 );

        String cardPower = card.substring(0, card.length() - 1);
        String type= card.substring(card.length() - 1);

        return mapOfCardPoints.get(cardPower) * mapOfCardPoints.get(type);
    }
}
