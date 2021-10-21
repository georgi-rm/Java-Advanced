public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String weightAsString = this.displacement == -1
                ? "n/a"
                : String.valueOf(this.displacement);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.model).append(":").append(System.lineSeparator())
                .append("Power: ").append(this.power).append(System.lineSeparator())
                .append("Displacement: ").append(weightAsString).append(System.lineSeparator())
                .append("Efficiency: ").append(this.efficiency);

        return stringBuilder.toString();
    }
}
