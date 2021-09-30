import java.util.ArrayDeque;
import java.util.Scanner;

public class P08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        ArrayDeque<String> outputQueue = new ArrayDeque<>();

        String[] input= scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            String token = input[i];

            if (isOperator(token)) {
                if (token.equals("(")) {
                    operatorsStack.push(token);
                } else if (token.equals(")")) {
                    while (!operatorsStack.isEmpty()) {
                        String lastOperator = operatorsStack.pop();
                        if (lastOperator.equals("(")) {
                            break;
                        } else {
                            outputQueue.offer(lastOperator);
                        }
                    }
                }
                else {
                    while (!operatorsStack.isEmpty()) {
                        String lastOperator = operatorsStack.peek();

                        if (lastOperator.equals("(")) {
                            break;
                        } else if (getPrecedence(token) > getPrecedence(lastOperator)) {
                            break;
                        } else {
                            outputQueue.offer(operatorsStack.pop());
                        }
                    }
                    operatorsStack.push(token);
                }
            } else {
                outputQueue.offer(token);
            }
        }

        while (!operatorsStack.isEmpty()) {
            outputQueue.offer(operatorsStack.pop());
        }

        for (String element : outputQueue) {
            System.out.printf("%s ", element);
        }

    }

    private static int getPrecedence(String token) {
        switch (token) {
            case "+":
            case "-":
                return 2;
            case "*":
            case "/":
                return 3;
            case "^":
                return 4;
            case "(":
            case ")":
                return 5;
        }
        return 0;
    }

    private static boolean isOperator(String token) {
        switch (token) {
            case "+":
            case "-":
            case "*":
            case "/":
            case "(":
            case ")":
                return true;
        }
        return false;
    }

}
