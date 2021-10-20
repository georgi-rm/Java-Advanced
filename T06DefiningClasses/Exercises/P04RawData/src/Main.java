import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> allCars = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0) {
            allCars.add(new Car(scanner.nextLine().split("\\s+")));
        }

        String typeOfCargo = scanner.nextLine();

        if (typeOfCargo.equals("fragile")) {
            allCars.stream()
                    .filter(car -> car.getCargo().getType().equals(typeOfCargo) && car.isTirePressureLessThan(1.0))
                    .forEach(System.out::println);
        } else {
            allCars.stream()
                    .filter(car -> car.getCargo().getType().equals(typeOfCargo) && car.getEngine().getPower() > 250)
                    .forEach(System.out::println);
        }
    }
}
