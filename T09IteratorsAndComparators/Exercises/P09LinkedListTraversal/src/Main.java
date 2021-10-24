import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList linkedList = new LinkedList();

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        while (numberOfCommands-- > 0) {
            String[] commandParameters = scanner.nextLine().split("\\s+");
            String commandName = commandParameters[0];
            int value = Integer.parseInt(commandParameters[1]);
            if (commandName.equals("Add")) {
                linkedList.addLast(value);
            } else {
                linkedList.removeFirstElement(value);
            }
        }

        System.out.println(linkedList.getSize());
        linkedList.forEach(e -> System.out.printf("%d ", e));
    }
}
