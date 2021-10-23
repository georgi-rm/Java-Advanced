public class StreetExtraordinaire extends Cat{
    public StreetExtraordinaire(String name, double specialValue) {
        super(name, specialValue);
    }

    @Override
    public String toString() {
        return String.format("StreetExtraordinaire %s", super.toString());
    }
}
