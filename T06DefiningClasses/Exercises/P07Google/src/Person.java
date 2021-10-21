import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private Company company;
    private List<Pokemon> pokemonList;
    private List<Parent> parentsList;
    private List<Child> childrenList;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.company = null;
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.car = null;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }
    public void addParent(Parent parent) {
        this.parentsList.add(parent);
    }
    public void addChild(Child child) {
        this.childrenList.add(child);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name).append(System.lineSeparator())
                .append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            stringBuilder.append(this.company).append(System.lineSeparator());
        }
        stringBuilder.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            stringBuilder.append(this.car).append(System.lineSeparator());
        }
        stringBuilder.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemonList) {
            stringBuilder.append(pokemon).append(System.lineSeparator());
        }
        stringBuilder.append("Parents:").append(System.lineSeparator());
        for (Parent parent : parentsList) {
            stringBuilder.append(parent).append(System.lineSeparator());
        }
        stringBuilder.append("Children:").append(System.lineSeparator());
        for (Child child : childrenList) {
            stringBuilder.append(child).append(System.lineSeparator());
        }


        return stringBuilder.toString();
    }
}
