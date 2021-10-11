import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<String>> listOfBoxes = new ArrayList<>();

        int lines = Integer.parseInt(scanner.nextLine());
        for (int line = 0; line < lines; line++) {
            String newLine = scanner.nextLine();
            Box<String> box = new Box<>(newLine);
            listOfBoxes.add(box);
        }

        String compareToString = scanner.nextLine();
        Box<String> compareToElement = new Box<>(compareToString);

        int counter = getCountOfGreaterElements(listOfBoxes, compareToElement);
        System.out.println(counter);

    }

    private static <T extends Comparable<T>> int getCountOfGreaterElements(List<Box<T>> list, Box<T> elementToCompare) {
        int counter = 0;
        for (Box<T> element : list) {
            if ( element.compareTo(elementToCompare) > 0 ) {
                counter++;
            }
        }
        return counter;
    }
}
