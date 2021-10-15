import java.util.*;

public class P01MagicBox {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstMagicBox::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondMagicBox::push);

        List<Integer> collectionOfClaimedItems = new ArrayList<>();
        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {
            int numberFromFirstMagicBox = firstMagicBox.peek();
            int numberFromSecondMagicBox = secondMagicBox.pop();

            int sumOfNumbers = numberFromFirstMagicBox + numberFromSecondMagicBox;

            if (sumOfNumbers % 2 == 0) {
                collectionOfClaimedItems.add(sumOfNumbers);
                firstMagicBox.poll();
            } else {
                firstMagicBox.offer(numberFromSecondMagicBox);
            }
        }

        System.out.println(firstMagicBox.isEmpty() ?
                "First magic box is empty." :
                "Second magic box is empty.");

        int sumOfClaimedItems = collectionOfClaimedItems
                .stream()
                .mapToInt(e -> e)
                .sum();

        String message;
        if(sumOfClaimedItems >= 90) {
            message = "Wow, your prey was epic! Value:";
        } else {
            message = "Poor prey... Value:";
        }

        System.out.printf("%s %d", message, sumOfClaimedItems);
    }
}
