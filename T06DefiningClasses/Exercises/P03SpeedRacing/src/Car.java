public class Car {
    private final String model;
    private double amountOfFuel;
    private final double fuelPerKm;
    private int distanceTraveled;

    public Car(String model, double amountOfFuel, double fuelPerKm) {
        this.model = model;
        this.amountOfFuel = amountOfFuel;
        this.fuelPerKm = fuelPerKm;
    }

    public boolean drive(int distance) {
        double fuelNeeded = distance * this.fuelPerKm;

        if (fuelNeeded > this.amountOfFuel) {
            return false;
        }

        this.amountOfFuel -= fuelNeeded;
        this.distanceTraveled += distance;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.amountOfFuel, this.distanceTraveled);
    }
}
