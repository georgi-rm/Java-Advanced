import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> peopleSortedByName = new TreeSet<>(new NameComparator());
        Set<Person> peopleSortedByAge = new TreeSet<>(new AgeComparator());

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        while (numberOfPeople-- > 0) {
            String[] peopleParameters = scanner.nextLine().split("\\s+");
            String personName = peopleParameters[0];
            int personAge = Integer.parseInt(peopleParameters[1]);
            Person person = new Person(personName, personAge);
            peopleSortedByName.add(person);
            peopleSortedByAge.add(person);
        }

        peopleSortedByName.forEach(System.out::println);
        peopleSortedByAge.forEach(System.out::println);
    }
}
