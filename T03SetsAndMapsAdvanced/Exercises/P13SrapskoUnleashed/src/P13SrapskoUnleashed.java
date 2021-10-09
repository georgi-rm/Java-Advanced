import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13SrapskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\b(?<nameOfSinger>[a-zA-Z]+ ?[a-zA-Z]* ?[a-zA-Z]*) @(?<town>[a-zA-Z]+ ?[a-zA-Z]* ?[a-zA-Z]*) (?<ticketsPrice>[\\d]+) (?<ticketsCount>[\\d]+)");

        Map<String, Map<String, Integer>> venues = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String nameOfSinger = matcher.group("nameOfSinger");
                String venueName = matcher.group("town");
                int ticketsPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                int ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));

                venues.putIfAbsent(venueName, new LinkedHashMap<>());
                Map<String, Integer> singerForCurrentVenue = venues.get(venueName);
                singerForCurrentVenue.putIfAbsent(nameOfSinger, 0);
                int moneyEarned = singerForCurrentVenue.get(nameOfSinger);
                moneyEarned += ticketsCount * ticketsPrice;
                singerForCurrentVenue.put(nameOfSinger, moneyEarned);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> venue : venues.entrySet()) {
            System.out.println(venue.getKey());
            venue.getValue().entrySet()
                    .stream()
                    .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                    .forEach(entry -> System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue()));
        }
    }
}
