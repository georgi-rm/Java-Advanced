import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0) {
            String[] carParameters = scanner.nextLine().split("\\s+");
            Car car = new Car();
            car.setBrand(carParameters[0]);
            car.setModel(carParameters[1]);
            car.setHorsePower(Integer.parseInt(carParameters[2]));

            System.out.println(car.carInfo());
        }
    }
}
