import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNames = Integer.parseInt(scanner.nextLine());

        Set<String> setWithNames = new LinkedHashSet<>();

        for (int ixName = 0; ixName < numberOfNames; ixName++) {
            String name = scanner.nextLine();

            setWithNames.add(name);
        }

        for (String name : setWithNames) {
            System.out.println(name);
        }
    }
}
