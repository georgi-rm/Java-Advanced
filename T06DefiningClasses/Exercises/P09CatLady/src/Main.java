import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commandParameters = input.split("\\s+");
            String catBreed = commandParameters[0];
            String catName = commandParameters[1];
            double specialValue = Double.parseDouble(commandParameters[2]);

            Cat cat = null;
            switch (catBreed) {
                case "Siamese":
                    cat = new Siamese(catName, specialValue);
                    break;
                case "Cymric":
                    cat = new Cymric(catName, specialValue);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(catName, specialValue);
                    break;
            }
            cats.put(catName, cat);
            input = scanner.nextLine();
        }

        String nameOfCatToPrint = scanner.nextLine();

        System.out.println(cats.get(nameOfCatToPrint));
    }
}
