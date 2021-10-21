import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new HashMap<>();

        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        while (numberOfEngines-- > 0) {
            String[] engineParameters = scanner.nextLine().split("\\s+");
            String engineModel = engineParameters[0];
            int enginePower = Integer.parseInt(engineParameters[1]);

            Engine engine;

            if (engineParameters.length == 3 ) {
                try {
                    int engineDisplacement = Integer.parseInt(engineParameters[2]);
                    engine = new Engine(engineModel, enginePower, engineDisplacement);
                } catch ( NumberFormatException e) {
                    String engineEfficiency = engineParameters[2];
                    engine = new Engine(engineModel, enginePower, engineEfficiency);
                }
            } else if (engineParameters.length == 4){
                int engineDisplacement = Integer.parseInt(engineParameters[2]);
                String engineEfficiency = engineParameters[3];
                engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            } else {
                engine = new Engine(engineModel, enginePower);
            }
            engines.put(engineModel, engine);
        }

        List<Car> listWithCars = new ArrayList<>();
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0) {
            String[] carParameters = scanner.nextLine().split("\\s+");
            String carModel = carParameters[0];
            String carEngineModel = carParameters[1];
            Engine carEngine = engines.get(carEngineModel);
            Car newCar;
            if (carParameters.length == 3) {
                try {
                    int weight = Integer.parseInt(carParameters[2]);
                    newCar = new Car(carModel, carEngine, weight);
                } catch (NumberFormatException e) {
                    String color = carParameters[2];
                    newCar = new Car(carModel, carEngine, color);
                }
            } else if (carParameters.length == 4) {
                int weight = Integer.parseInt(carParameters[2]);
                String color = carParameters[3];
                newCar = new Car(carModel, carEngine, weight, color);
            } else {
                newCar = new Car(carModel, carEngine);
            }

            listWithCars.add(newCar);
        }

        listWithCars.forEach(System.out::println);
    }
}
