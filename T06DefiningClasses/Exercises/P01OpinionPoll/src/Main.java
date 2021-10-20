import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split(" +");
            int age = Integer.parseInt(input[1]);
            Person newPerson = new Person(input[0], age );
            people.add(newPerson);
        }
        people.stream()
                .filter(e -> e.getAge() > 30)
                .sorted( Comparator.comparing(Person::getName))
                .forEach(person -> System.out.printf("%s - %d%n", person.getName(), person.getAge()));
    }
}
