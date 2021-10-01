import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwardUrls = new ArrayDeque<>();
        String instruction = scanner.nextLine();

        while (!instruction.equals("Home")) {
            if (instruction.equals("back")) {
                if (history.size() > 1) {
                    forwardUrls.push(history.pop());
                    String previousPage = history.peek();
                    System.out.println(previousPage);
                } else {
                    System.out.println("no previous URLs");
                }
            } else if (instruction.equals("forward")) {
                if (forwardUrls.isEmpty()){
                    System.out.println("no next URLs");
                } else {
                    String nextPage = forwardUrls.pop();
                    history.push(nextPage);
                    System.out.println(nextPage);
                }
            }
            else
            {
                history.push(instruction);
                forwardUrls.clear();
                System.out.println(instruction);
            }

            instruction = scanner.nextLine();
        }
    }
}
