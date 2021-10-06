import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commandData = input.split(", ");
            String action = commandData[0];
            String licencePlate = commandData[1];
            if (action.equals("IN")) {
                parkingLot.add(licencePlate);
            } else {
                parkingLot.remove(licencePlate);
            }
            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parkingLot.forEach(System.out::println);
        }
    }
}
