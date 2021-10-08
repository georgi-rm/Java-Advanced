import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> users = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commandData = input.split("[=\\s+]");
            String ip = commandData[1];
            String username = commandData[5];
            users.putIfAbsent(username, new LinkedHashMap<>());
            Map<String, Integer> ipAddresses = users.get(username);
            ipAddresses.putIfAbsent(ip, 0);
            int countOfIpRecords = ipAddresses.get(ip);
            countOfIpRecords++;
            ipAddresses.put(ip, countOfIpRecords);
            input = scanner.nextLine();
        }

        users.forEach((userKey, userValue) -> {
            System.out.printf("%s:%n", userKey);
            String printIps = userValue.entrySet()
                    .stream()
                    .map(e -> String.format("%s => %d", e.getKey(), e.getValue()))
                    .collect(Collectors.joining(", "));
            System.out.println(printIps + ".");
        });

    }
}
