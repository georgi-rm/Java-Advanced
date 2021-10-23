import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;
    private final List<String> parents;
    private final List<String> children;

    public Person() {
        this.name = null;
        this.birthDate = null;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public Person(String name, String birthDate) {
        this();
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<String> getParents() {
        return parents;
    }

    public List<String> getChildren() {
        return children;
    }

    public void addParent(String parent) {
        this.parents.add(parent);
    }

    public void addChild(String child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        if (this.name == null) {
            return " " + this.birthDate;
        }
        if (this.birthDate == null) {
            return this.name + " ";
        }
        return String.format("%s %s", this.name, this.birthDate);
    }

    public boolean isParent(String person) {
        return children.contains(person);
    }

    public boolean isChild(String person) {
        return parents.contains(person);
    }
}
