import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstCommandParameters = scanner.nextLine().split("\\s+");
        String name = firstCommandParameters[0] + " " + firstCommandParameters[1];
        String town = firstCommandParameters[2];
        Tuple<String, String> firstObject = new Tuple<>(name, town);
        System.out.println(firstObject);

        String[] secondCommandParameters = scanner.nextLine().split("\\s+");
        name = secondCommandParameters[0];
        int litersOfBeer = Integer.parseInt(secondCommandParameters[1]);
        Tuple<String, Integer> secondObject = new Tuple<>(name, litersOfBeer);
        System.out.println(secondObject);

        String[] thirdCommandParameters = scanner.nextLine().split("\\s+");
        int number = Integer.parseInt(thirdCommandParameters[0]);
        double doubleNumber = Double.parseDouble(thirdCommandParameters[1]);
        Tuple<Integer, Double> thirdObject = new Tuple<>(number, doubleNumber);
        System.out.println(thirdObject);


    }
}
