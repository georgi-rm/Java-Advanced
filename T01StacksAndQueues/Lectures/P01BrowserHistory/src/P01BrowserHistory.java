import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        String instruction = scanner.nextLine();

        while (!instruction.equals("Home")) {
            if (instruction.equals("back")) {
                if (history.size() > 1) {
                    history.pop();
                    String previousPage = history.peek();
                    System.out.println(previousPage);
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                history.push(instruction);
                System.out.println(instruction);
            }

            instruction = scanner.nextLine();
        }
    }
}
