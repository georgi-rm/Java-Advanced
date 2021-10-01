import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queueOfPlayers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(queueOfPlayers::offer);

        int numberOfToss = Integer.parseInt(scanner.nextLine());
        int currentToss = 0;
        while (queueOfPlayers.size() > 1) {
            currentToss++;
            String player = queueOfPlayers.poll();
            if (currentToss == numberOfToss) {
                currentToss = 0;
                System.out.printf("Removed %s%n", player);
            } else {
                queueOfPlayers.offer(player);
            }
        }
        System.out.printf("Last is %s", queueOfPlayers.poll());
    }
}
