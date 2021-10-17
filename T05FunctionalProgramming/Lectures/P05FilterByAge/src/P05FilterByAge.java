import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P05FilterByAge {
    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", this.name, this.age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        Supplier<Person> personCreator = () -> {
            String[] commandParameters = scanner.nextLine().split(", ");
            String name = commandParameters[0];
            int age = Integer.parseInt(commandParameters[1]);
            return new Person(name, age);
        };

        List<Person> people = IntStream.range(0, numberOfPeople)
                .mapToObj(ignored -> personCreator.get())
                .collect(Collectors.toList());

        String condition = scanner.nextLine();
        int compareAge = Integer.parseInt(scanner.nextLine());
        String[] format = scanner.nextLine().split("\\s+");

        Predicate<Person> filterByAge = getFilterByAge(condition, compareAge);

        Consumer<Person> printPerson = getPrintByFormat(format);

        people.stream()
                .filter(filterByAge)
                .forEach(printPerson);

    }

    private static Consumer<Person> getPrintByFormat(String[] format) {
        if (format.length > 1) {
            return System.out::println;
        } else if (format[0].equals("name")) {
            return p -> System.out.println(p.getName());
        } else {
            return p -> System.out.println(p.getAge());
        }
    }

    private static Predicate<Person> getFilterByAge(String condition, int age) {
        if (condition.equals("older")) {
            return p -> p.getAge() >= age;
        }
        return p -> p.getAge() <= age;
    }
}
