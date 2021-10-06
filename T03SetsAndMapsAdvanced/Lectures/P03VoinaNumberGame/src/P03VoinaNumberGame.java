import java.util.*;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> deckOfFirstPlayer = new LinkedHashSet<>();
        Set<Integer> deckOFSecondPlayer = new LinkedHashSet<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(deckOfFirstPlayer::add);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(deckOFSecondPlayer::add);

        int rounds = 50;
        while (rounds-- > 0 && !deckOfFirstPlayer.isEmpty() && !deckOFSecondPlayer.isEmpty()) {
            Iterator<Integer> firstIterator = deckOfFirstPlayer.iterator();
            Iterator<Integer> secondIterator = deckOFSecondPlayer.iterator();
            int firstPlayerCard = firstIterator.next();
            firstIterator.remove();
            int secondPlayerCard = secondIterator.next();
            secondIterator.remove();

            if (firstPlayerCard > secondPlayerCard) {
                deckOfFirstPlayer.add(firstPlayerCard);
                deckOfFirstPlayer.add(secondPlayerCard);
            } else if (firstPlayerCard < secondPlayerCard) {
                deckOFSecondPlayer.add(firstPlayerCard);
                deckOFSecondPlayer.add(secondPlayerCard);
            } else {
                deckOfFirstPlayer.add(firstPlayerCard);
                deckOFSecondPlayer.add(secondPlayerCard);
            }
        }

        String output;
        if (deckOfFirstPlayer.size() > deckOFSecondPlayer.size()) {
            output = "First player win!";
        } else if (deckOfFirstPlayer.size() < deckOFSecondPlayer.size()) {
            output = "Second player win!";
        } else {
            output = "Draw!";
        }

        System.out.println(output);
    }
}
