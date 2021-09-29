import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> input = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(input::push);

        ArrayDeque<String> stack = new ArrayDeque<>();
        input.forEach(stack::push);

        int firstOperand = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()) {
            boolean isOperationAddition = stack.pop().equals("+");

            int secondOperand = Integer.parseInt(stack.pop());

            if( isOperationAddition ) {
                firstOperand += secondOperand;
            } else {
                firstOperand -= secondOperand;
            }
        }
        System.out.println(firstOperand);
    }
}
