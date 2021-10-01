import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputExpression = scanner.nextLine();

        ArrayDeque<Integer> indexesOfBrackets = new ArrayDeque<>();

        for (int i = 0; i < inputExpression.length(); i++) {
            if (inputExpression.charAt(i) == '(') {
                indexesOfBrackets.push(i);
            } else if (inputExpression.charAt(i) == ')') {
                String expression = inputExpression.substring(indexesOfBrackets.pop(), i + 1);
                System.out.println(expression);
            }
        }
    }
}
