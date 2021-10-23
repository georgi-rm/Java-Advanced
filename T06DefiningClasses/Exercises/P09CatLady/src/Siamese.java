public class Siamese extends Cat{

    public Siamese(String name, double specialValue) {
        super(name, specialValue);
    }

    @Override
    public String toString() {
        return String.format("Siamese %s", super.toString());
    }
}
