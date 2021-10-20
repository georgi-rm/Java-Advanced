import java.util.Arrays;

public class Car {
    private final String model;
    private final Engine engine;
    private final Cargo cargo;
    private final Tire[] tires;

    public Car(String[] carData) {
        this.model = carData[0];
        int engineSpeed = Integer.parseInt(carData[1]);
        int enginePower = Integer.parseInt(carData[2]);
        this.engine = new Engine(engineSpeed, enginePower);
        int cargoWeight = Integer.parseInt(carData[3]);
        String cargoType = carData[4];
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires = new Tire[4];
        for (int i = 0; i < this.tires.length; i++) {
            double tirePressure = Double.parseDouble(carData[5 + i * 2]);
            int tireAge = Integer.parseInt(carData[6 + i * 2]);
            this.tires[i] = new Tire(tirePressure, tireAge);
        }
    }

    @Override
    public String toString() {
        return this.model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTires() {
        return tires;
    }

    public boolean isTirePressureLessThan(double pressure) {
        for (Tire tire : tires) {
            if (tire.getPressure() < pressure) {
                return true;
            }
        }
        return false;
    }
}
