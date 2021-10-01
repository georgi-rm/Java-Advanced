import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> plantsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .limit(numberOfPlants)
                .map(Integer::parseInt)
                .forEach(plantsQueue::offer);

        int days = 0;
        int plantCounter = 0;
        int numberOfDeadPlants = 0;
        int pesticideLevelOfPreviousPlant = Integer.MAX_VALUE;

        while (!plantsQueue.isEmpty()) {
            if (plantCounter == numberOfPlants) {
                if (numberOfDeadPlants == 0) {
                    break;
                }
                days++;
                plantCounter = 0;
                numberOfPlants = plantsQueue.size();
                numberOfDeadPlants = 0;
                pesticideLevelOfPreviousPlant = Integer.MAX_VALUE;
            }
            int pesticideLevelOfCurrentPlant = plantsQueue.poll();

            if (pesticideLevelOfCurrentPlant <= pesticideLevelOfPreviousPlant){
                if (numberOfDeadPlants != 0) {
                    plantsQueue.offer(pesticideLevelOfCurrentPlant);
                }
            } else {
                if (numberOfDeadPlants == 0) {
                    plantsQueue.offer(pesticideLevelOfPreviousPlant);
                }
                numberOfDeadPlants++;
            }
            pesticideLevelOfPreviousPlant = pesticideLevelOfCurrentPlant;
            plantCounter++;
        }
        System.out.println(days);
    }
}
