import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstCommandParameters = scanner.nextLine().split("\\s+");
        String name = String.format("%s %s",firstCommandParameters[0], firstCommandParameters[1]);
        String address = firstCommandParameters[2];
        String town = firstCommandParameters[3];
        Threeuple<String, String, String> firstObject = new Threeuple<>(name, address, town);
        System.out.println(firstObject);

        String[] secondCommandParameters = scanner.nextLine().split("\\s+");
        name = secondCommandParameters[0];
        int litersOfBeer = Integer.parseInt(secondCommandParameters[1]);
        boolean drinkOrNot = secondCommandParameters[2].equals("drunk");
        Threeuple<String, Integer, Boolean> secondObject = new Threeuple<>(name, litersOfBeer, drinkOrNot);
        System.out.println(secondObject);

        String[] thirdCommandParameters = scanner.nextLine().split("\\s+");
        name = thirdCommandParameters[0];
        double accountBalance = Double.parseDouble(thirdCommandParameters[1]);
        String bankName = thirdCommandParameters[2];
        Threeuple<String, Double, String> thirdObject = new Threeuple<>(name, accountBalance, bankName);
        System.out.println(thirdObject);


    }
}
