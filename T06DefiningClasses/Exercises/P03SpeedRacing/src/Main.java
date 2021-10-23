import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0) {
            String[] carData = scanner.nextLine().split("\\s+");
            String carModel = carData[0];
            double amountOfFuel = Double.parseDouble(carData[1]);
            double fuelPerKm = Double.parseDouble(carData[2]);
            cars.put(carModel, new Car(carModel, amountOfFuel, fuelPerKm));
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commandParameters = input.split("\\s+");
            String carModel = commandParameters[1];
            int distance = Integer.parseInt(commandParameters[2]);
            if (!cars.get(carModel).drive(distance) ) {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scanner.nextLine();
        }

        for (Car car : cars.values()) {
            System.out.println(car);
        }
    }
}
