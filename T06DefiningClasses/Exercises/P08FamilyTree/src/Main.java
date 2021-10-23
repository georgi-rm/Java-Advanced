import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> allPeople = new ArrayList<>();

        String firstPersonData = scanner.nextLine();
        Person firstPerson = new Person();
        if (firstPersonData.contains(" ")) {
            firstPerson.setName(firstPersonData);
        } else {
            firstPerson.setBirthDate(firstPersonData);
        }
        allPeople.add(firstPerson);

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] inputParameters = input.split(" - ");

            if (inputParameters.length == 1) {
                String[] personData = input.split("\\s+");
                String name = String.format("%s %s", personData[0], personData[1]);
                String birthDate = personData[2];

                Person personByName = findPersonByName(name, allPeople);
                Person personByBirthDate = findPersonByBirthDate(birthDate, allPeople);
                if (personByName != null && personByBirthDate != null) {
                    int indexOfPersonByName = allPeople.indexOf(personByName);
                    int indexOfPersonByBirthDate = allPeople.indexOf(personByBirthDate);
                    if (indexOfPersonByName < indexOfPersonByBirthDate) {
                        personByName.setBirthDate(birthDate);
                        for (String parent : personByBirthDate.getParents()) {
                            personByName.addParent(parent);
                        }
                        for (String child : personByBirthDate.getChildren()) {
                            personByName.addChild(child);
                        }
                        allPeople.remove(indexOfPersonByBirthDate);
                    } else if (indexOfPersonByName > indexOfPersonByBirthDate) {
                        personByBirthDate.setName(name);
                        for (String parent : personByName.getParents()) {
                            personByBirthDate.addParent(parent);
                        }
                        for (String child : personByName.getChildren()) {
                            personByBirthDate.addChild(child);
                        }
                        allPeople.remove(indexOfPersonByName);
                    }
                } else if (personByName != null) {
                    personByName.setBirthDate(birthDate);
                } else if (personByBirthDate != null) {
                    personByBirthDate.setName(name);
                } else {
                    allPeople.add(new Person(name, birthDate));
                }
            } else {
                Person parent = null;
                Person child = null;
                String parentData = inputParameters[0];
                String childData = inputParameters[1];
                if (parentData.contains(" ")) {
                    parent = findPersonByName(parentData, allPeople);
                    if (parent == null) {
                        parent = new Person();
                        parent.setName(parentData);
                        allPeople.add(parent);
                    }
                } else {
                    parent = findPersonByBirthDate(parentData, allPeople);
                    if (parent == null) {
                        parent = new Person();
                        parent.setBirthDate(parentData);
                        allPeople.add(parent);
                    }
                }


                if (childData.contains(" ")) {
                    child = findPersonByName(childData, allPeople);
                    if (child == null) {
                        child = new Person();
                        child.setName(childData);
                        allPeople.add(child);
                    }
                } else {
                    child = findPersonByBirthDate(childData, allPeople);
                    if (child == null) {
                        child = new Person();
                        child.setBirthDate(childData);
                        allPeople.add(child);
                    }
                }

                parent.addChild(childData);
                child.addParent(parentData);
            }
            input = scanner.nextLine();
        }

        Person chosenOne = allPeople.get(0);
        System.out.println(chosenOne);
        System.out.println("Parents:");
        for (Person person : allPeople) {
            if (person.isParent(chosenOne.getName())
                    || person.isParent(chosenOne.getBirthDate())) {
                System.out.println(person);
            }
        }
        System.out.println("Children:");
        for (Person person : allPeople) {
            if (person.isChild(chosenOne.getName())
                    || person.isChild(chosenOne.getBirthDate())) {
                System.out.println(person);
            }
        }
    }

    public static Person findPersonByName(String name, List<Person> allPeople) {
        for (Person person : allPeople) {
            if (name.equals(person.getName())) {
                return person;
            }
        }
        return null;
    }

    public static Person findPersonByBirthDate(String birthDate, List<Person> allPeople) {
        for (Person person : allPeople) {
            if (birthDate.equals(person.getBirthDate())) {
                return person;
            }
        }
        return null;
    }
}
