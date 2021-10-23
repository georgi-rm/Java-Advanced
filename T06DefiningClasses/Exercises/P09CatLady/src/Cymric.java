public class Cymric extends Cat{
    public Cymric(String name, double specialValue) {
        super(name, specialValue);
    }

    @Override
    public String toString() {
        return String.format("Cymric %s", super.toString());
    }
}
