import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0) {
            String[] carParameters = scanner.nextLine().split("\\s+");
            String brand = carParameters[0];

            Car car;
            if (carParameters.length == 1) {
                car = new Car(brand);
            } else {
                String model = carParameters[1];
                if (carParameters.length == 2) {
                    car = new Car(brand, model);
                } else {
                    int horsePower = Integer.parseInt(carParameters[2]);
                    car = new Car(brand, model, horsePower);
                }
            }

            System.out.println(car.carInfo());
        }
    }
}
