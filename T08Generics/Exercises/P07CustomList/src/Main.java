import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> myList = new CustomList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commandParameters = input.split("\\s+");
            String command = commandParameters[0];

            switch (command) {
                case "Add":
                    String elementToAdd = commandParameters[1];
                    myList.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commandParameters[1]);
                    myList.remove(indexToRemove);
                    break;
                case "Contains":
                    String elementToSearch = commandParameters[1];
                    System.out.println(myList.contains(elementToSearch));
                    break;
                case "Swap":
                    int indexOfFirstElement = Integer.parseInt(commandParameters[1]);
                    int indexOfSecondElement = Integer.parseInt(commandParameters[2]);
                    myList.swap(indexOfFirstElement, indexOfSecondElement);
                    break;
                case "Greater":
                    String elementToCompare = commandParameters[1];
                    System.out.println(myList.countGreaterThan(elementToCompare));
                    break;
                case "Max":
                    System.out.println(myList.getMax());
                    break;
                case "Min":
                    System.out.println(myList.getMin());
                    break;
                case "Print":
                    System.out.print(myList);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
