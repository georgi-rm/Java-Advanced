import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box<Integer>> listOfBoxes = new ArrayList<>();
        int lines = Integer.parseInt(scanner.nextLine());
        for (int line = 0; line < lines; line++) {
            Box<Integer> box = new Box<>();
            box.setValue(Integer.parseInt(scanner.nextLine()));
            listOfBoxes.add(box);
        }

        String[] indexes = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(indexes[0]);
        int secondIndex = Integer.parseInt(indexes[1]);
        swapListElements(firstIndex, secondIndex, listOfBoxes);

        for (Box<Integer> box : listOfBoxes) {
            System.out.println(box);
        }
    }

    private static <T> void swapListElements(int firstIndex, int secondIndex, List<T> list) {
        T element = list.get(firstIndex);
        list.set(firstIndex, list.get(secondIndex));
        list.set(secondIndex, element);
    }
}
