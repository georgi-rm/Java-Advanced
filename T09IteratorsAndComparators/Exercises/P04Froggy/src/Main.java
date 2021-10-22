import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] input = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        scanner.nextLine();

        Lake lake = new Lake(input);

        List<String> output = new ArrayList<>();

        for (Integer stone : lake) {
            output.add(String.valueOf(stone));
        }

        System.out.println(String.join(", ", output));
    }
}
