import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        do {
            stack.push(input % 2);
            input /= 2;
        } while (input > 0);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
