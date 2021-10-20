import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guestList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] commandParams = input.split("\\s+");
            String command = commandParams[0];
            Predicate<String> predicate = producePredicate(commandParams[1], commandParams[2]);

            assert predicate != null;


            switch (command) {
                case "Remove":
                    Set<String> selectedGuests = guestList
                            .stream()
                            .filter(predicate)
                            .collect(Collectors.toSet());
                    for (String selectedGuest : selectedGuests) {
                        while (guestList.contains(selectedGuest)) {
                            guestList.remove(selectedGuest);
                        }
                    }
                    break;
                case "Double":
                    List<String> addGuests = guestList
                            .stream()
                            .filter(predicate)
                            .collect(Collectors.toList());
                    guestList.addAll(addGuests);
                    break;
            }
            input = scanner.nextLine();
        }

        if (guestList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            String output = guestList.stream()
                    .sorted()
                    .collect(Collectors.joining(", "));
            System.out.printf("%s are going to the party!", output);
        }

    }

    private static Predicate<String> producePredicate(String condition, String value) {
        switch (condition) {
            case "StartsWith":
                return name -> name.startsWith(value);
            case "EndsWith":
                return name -> name.endsWith(value);
            case "Length":
                return name -> name.length() == Integer.parseInt(value);
            default:
                return null;
        }
    }
}
