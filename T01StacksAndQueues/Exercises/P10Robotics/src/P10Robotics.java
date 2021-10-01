import java.util.*;

public class P10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Robot> robots = new ArrayList<>();
        String[] inputRobots = scanner.nextLine().split(";");

        for (String robot : inputRobots) {
            String[] params = robot.split("-");
            String robotName = params[0];
            int robotProcessingTime = Integer.parseInt(params[1]);
            robots.add(new Robot(robotName,robotProcessingTime));
        }

        String[] timeParams = scanner.nextLine().split(":");
        int initialHours = Integer.parseInt(timeParams[0]);
        int initialMinutes = Integer.parseInt(timeParams[1]);
        int initialSeconds = Integer.parseInt(timeParams[2]);

        ArrayDeque<String> productQueue = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            productQueue.offer(input);
            input = scanner.nextLine();
        }

        int currentSeconds = 0;
        while (!productQueue.isEmpty()) {
            currentSeconds++;
            String product = productQueue.poll();
            boolean isProductProcessed = false;
            for (Robot robot : robots) {
                if (!robot.isBusy(currentSeconds)) {
                    robot.beginWork(currentSeconds);
                    String timeStamped = timeWithAddedSeconds(initialHours, initialMinutes, initialSeconds, currentSeconds);
                    System.out.printf("%s - %s [%s]%n", robot.getName(), product, timeStamped);
                    isProductProcessed = true;
                    break;
                }
            }
            if (!isProductProcessed) {
                productQueue.offer(product);
            }
        }

    }

    public static String timeWithAddedSeconds( int hours, int minutes, int seconds, int secondsToAdd) {
        seconds += secondsToAdd;
        if (seconds > 59) {
            minutes += seconds / 60;
            seconds %= 60;
            if (minutes > 59) {
                hours += minutes / 60;
                minutes %= 60;
                if (hours > 23) {
                    hours %= 24;
                }
            }
        }
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}
