import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private final String name;
    private int numberOfBadges;
    private final List<Pokemon> collectionOfPokemons;

    public Trainer(String name) {
        this.name = name;
        numberOfBadges = 0;
        collectionOfPokemons = new ArrayList<>();
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.collectionOfPokemons.add(pokemon);
    }

    public void elementUse(String elementName) {
        for (Pokemon pokemon : collectionOfPokemons) {
            if (pokemon.getElement().equals(elementName)) {
                this.numberOfBadges++;
                return;
            }
        }

        for (int i = collectionOfPokemons.size() - 1; i >= 0; i--) {
            Pokemon pokemon = collectionOfPokemons.get(i);
            pokemon.removeHealth(10);
            if (pokemon.getHealth() <= 0) {
                collectionOfPokemons.remove(i);
            }
        }
    }

    @Override
    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(this.name).

        return String.format("%s %d %d", this.name, this.numberOfBadges, this. collectionOfPokemons.size());
    }
}
