import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());
        for (int line = 0; line < lines; line++) {
            Box<String> lineData = new Box<>();
            lineData.setValue(scanner.nextLine());
            System.out.println(lineData);
        }
    }
}
