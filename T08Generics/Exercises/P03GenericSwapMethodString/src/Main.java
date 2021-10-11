import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<String>> listOfBoxes = new ArrayList<>();
        int lines = Integer.parseInt(scanner.nextLine());
        for (int line = 0; line < lines; line++) {
            Box<String> lineData = new Box<>();
            lineData.setValue(scanner.nextLine());
            listOfBoxes.add(lineData);
        }

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int firstIndex = indexes[0];
        int secondIndex = indexes[1];
        swapListElements(indexes[0], indexes[1], listOfBoxes);

        for (Box<String> box : listOfBoxes) {
            System.out.println(box);
        }

    }
    private static<T> void swapListElements(int firstIndex, int secondIndex, List<T> list) {
        T element;
        element = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, element);
    }
}
