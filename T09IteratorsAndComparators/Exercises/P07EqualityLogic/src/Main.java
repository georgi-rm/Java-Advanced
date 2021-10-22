import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> peopleHashSet = new HashSet<>();
        Set<Person> peopleTreeSet = new TreeSet<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        while (numberOfPeople-- > 0) {
            String[] peopleParameters = scanner.nextLine().split("\\s+");
            String personName = peopleParameters[0];
            int personAge = Integer.parseInt(peopleParameters[1]);
            Person person = new Person(personName, personAge);
            peopleHashSet.add(person);
            peopleTreeSet.add(person);
        }

        System.out.println(peopleTreeSet.size());
        System.out.println(peopleHashSet.size());
    }
}
