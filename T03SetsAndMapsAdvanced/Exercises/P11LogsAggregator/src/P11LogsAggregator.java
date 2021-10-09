import java.util.*;

public class P11LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputLines = Integer.parseInt(scanner.nextLine());

        Map<String, User> allUsers = new TreeMap<>();

        for (int line = 0; line < numberOfInputLines; line++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String newIpAddress = inputData[0];
            String userName = inputData[1];
            int duration = Integer.parseInt(inputData[2]);

            allUsers.putIfAbsent(userName, new User(userName));
            User userRecord = allUsers.get(userName);
            userRecord.addDuration(duration);
            userRecord.addIpAddress(newIpAddress);
        }
        allUsers.values().forEach(System.out::println);
    }
    private static class User {
        private final String name;
        private int duration;
        private final Set<String> ipAddresses;

        public User(String name) {
            this.name = name;
            this.duration = 0;
            this.ipAddresses = new TreeSet<>();
        }

        public void addDuration(int duration) {
            this.duration += duration;
        }

        public void addIpAddress(String ipAddresses) {
            this.ipAddresses.add(ipAddresses);
        }

        @Override
        public String toString() {
            return String.format("%s: %d %s", name, duration, ipAddresses.toString());
        }
    }
}
