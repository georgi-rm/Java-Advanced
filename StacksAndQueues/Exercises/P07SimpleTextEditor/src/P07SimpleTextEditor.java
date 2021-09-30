import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        StringBuilder workText = new StringBuilder();
        ArrayDeque<String> stackOfText = new ArrayDeque<>();

        for (int ixCommand = 0; ixCommand < numberOfCommands; ixCommand++) {
            String[] commandParameters = scanner.nextLine().split("\\s+");
            String commandNumber = commandParameters[0];

            switch (commandNumber) {
                case "1":
                    stackOfText.push(workText.toString());
                    String textToAppend = commandParameters[1];
                    workText.append(textToAppend);
                    break;
                case "2":
                    stackOfText.push(workText.toString());
                    int numberOfElementsToErase = Integer.parseInt(commandParameters[1]);
                    int startIndexToDelete = workText.length() - numberOfElementsToErase;
                    workText.delete(startIndexToDelete, workText.length());
                    break;
                case "3":
                    int indexToDisplay = Integer.parseInt(commandParameters[1]) - 1;
                    System.out.println(workText.charAt(indexToDisplay));
                    break;
                case "4":
                    if (stackOfText.isEmpty()) {
                        break;
                    }
                    workText.delete(0, workText.length());
                    workText.append(stackOfText.pop());
//                    workText.replace(0, workText.length(),stackOfText.pop());
                    break;
            }
        }
    }
}
