import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queueOfPlayers = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(queueOfPlayers::offer);

        int numberOfToss = Integer.parseInt(scanner.nextLine());
        int currentToss = 0;
        int cycles = 1;
        while (queueOfPlayers.size() > 1) {
            currentToss++;
            String player = queueOfPlayers.poll();
            if (currentToss == numberOfToss) {
                if (isPrime(cycles)) {
                    queueOfPlayers.offer(player);
                    System.out.printf("Prime %s%n", player);
                    currentToss = 1;
                } else {
                    System.out.printf("Removed %s%n", player);
                    currentToss = 0;
                }
                cycles++;
            } else {
                queueOfPlayers.offer(player);
            }
        }
        System.out.printf("Last is %s", queueOfPlayers.poll());
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number ; i++) {
            if ( number % i == 0 ) {
                return false;
            }
        }
        return true;
    }


}
