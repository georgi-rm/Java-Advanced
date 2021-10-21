import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commandParameters = input.split("\\s+");
            String personName = commandParameters[0];
            String commandName = commandParameters[1];
            people.putIfAbsent(personName, new Person(personName));
            Person currentPerson = people.get(personName);
            switch (commandName) {
                case "company":
                    String companyName = commandParameters[2];
                    String department = commandParameters[3];
                    double salary = Double.parseDouble(commandParameters[4]);
                    Company newCompany = new Company(companyName, department, salary);
                    currentPerson.setCompany(newCompany);
                    break;
                case "pokemon":
                    String pokemonName = commandParameters[2];
                    String pokemonType = commandParameters[3];
                    Pokemon newPokemon = new Pokemon(pokemonName, pokemonType);
                    currentPerson.addPokemon(newPokemon);
                    break;
                case "parents":
                    String parentName = commandParameters[2];
                    String parentBirthday = commandParameters[3];
                    Parent newParent = new Parent(parentName, parentBirthday);
                    currentPerson.addParent(newParent);
                    break;
                case "children":
                    String childName = commandParameters[2];
                    String childBirthday = commandParameters[3];
                    Child newChild = new Child(childName, childBirthday);
                    currentPerson.addChild(newChild);
                    break;
                case "car":
                    String carModel = commandParameters[2];
                    int carSpeed = Integer.parseInt(commandParameters[3]);
                    Car newCar = new Car(carModel, carSpeed);
                    currentPerson.setCar(newCar);
                    break;
            }

            input = scanner.nextLine();
        }

        String nameOfPersonToPrint = scanner.nextLine();

        System.out.println(people.get(nameOfPersonToPrint));
    }
}
