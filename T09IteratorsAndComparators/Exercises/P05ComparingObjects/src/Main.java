import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> listOfPeople = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commandParameters = input.split("\\s+");
            String nameOfPerson = commandParameters[0];
            int age = Integer.parseInt(commandParameters[1]);
            String town = commandParameters[2];
            listOfPeople.add(new Person(nameOfPerson, age, town));
            input = scanner.nextLine();
        }

        int indexOfPerson = Integer.parseInt(scanner.nextLine()) - 1;

        Person currentPerson = listOfPeople.get(indexOfPerson);

        int numberOfEqualPeople = 0;
        for (Person person : listOfPeople) {
            if (currentPerson.compareTo(person) == 0 ) {
                numberOfEqualPeople++;
            }
        }

        if (numberOfEqualPeople <= 1) {
            System.out.println("No matches");
        } else {
            int numberOfNotEqualPeople = listOfPeople.size() - numberOfEqualPeople;
            System.out.printf("%d %d %d%n", numberOfEqualPeople, numberOfNotEqualPeople, listOfPeople.size());
        }
    }
}
