import java.util.Objects;

public class Person implements Comparable<Person> {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %d", this.name, this.age);
    }

    @Override
    public int compareTo(Person other) {
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = Integer.compare(this.age, other.age);
        }
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other.getClass() != this.getClass()) {
            return false;
        }
        return this.compareTo((Person) other) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
