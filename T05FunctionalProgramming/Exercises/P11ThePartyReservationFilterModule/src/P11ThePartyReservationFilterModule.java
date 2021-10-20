import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        Map<String, Predicate<String>> predicates = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            String[] commandParams = input.split(";");
            String command = commandParams[0];
            String commandCondition = commandParams[1];
            String commandValue = commandParams[2];

            switch (command) {
                case "Remove filter":
                    predicates.remove( commandCondition + commandValue);
                    break;
                case "Add filter":
                    predicates.put(commandCondition+commandValue, producePredicate(commandCondition, commandValue));
                    break;
            }
            input = scanner.nextLine();
        }

        String output = guestList.stream()
                            .filter( name -> {
                                for (Predicate<String> predicate : predicates.values()) {
                                    if (predicate.test(name)) {
                                        return false;
                                    }
                                }
                                return true;
                            })
                            .collect(Collectors.joining(" "));
        System.out.println(output);
    }

    private static Predicate<String> producePredicate(String condition, String value) {
        switch (condition) {
            case "Starts with":
                return name -> name.startsWith(value);
            case "Ends with":
                return name -> name.endsWith(value);
            case "Length":
                return name -> name.length() == Integer.parseInt(value);
            case "Contains":
                return name -> name.contains(value);
            default:
                return null;
        }
    }
}
