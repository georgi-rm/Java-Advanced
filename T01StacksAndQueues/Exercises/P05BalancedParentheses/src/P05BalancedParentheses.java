import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);
            if ((currentSymbol == '(') || (currentSymbol == '[') || (currentSymbol == '{')) {
                stack.push(currentSymbol);
            } else if ((currentSymbol == ')') || (currentSymbol == ']') || (currentSymbol == '}')) {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpenedBracket = stack.pop();
                if (((lastOpenedBracket == '(') && (currentSymbol != ')'))
                        || ((lastOpenedBracket == '[') && (currentSymbol != ']'))
                        || ((lastOpenedBracket == '{') && (currentSymbol != '}'))) {
                    isBalanced = false;
                    break;
                }
            }
        }
        System.out.println(isBalanced ? "YES" : "NO");
    }
}
