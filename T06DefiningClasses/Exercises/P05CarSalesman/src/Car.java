public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        String weightAsString = this.weight == -1
                ? "n/a"
                : String.valueOf(this.weight);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.model).append(":").append(System.lineSeparator())
                .append(this.engine).append(System.lineSeparator())
                .append("Weight: ").append(weightAsString).append(System.lineSeparator())
                .append("Color: ").append(this.color);

        return stringBuilder.toString();
    }
}
