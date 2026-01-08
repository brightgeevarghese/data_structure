package learn.lesson_3.stack.postfix_evaluation;

import java.util.Stack;

public class Main {
    static double evaluatePostfixExpression(String postfixExpression) {
        String[] tokens = postfixExpression.split(" ");
        Stack<Double> resultStack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].matches("^\\d+$")) {
                resultStack.push(Double.parseDouble(tokens[i]));
            } else if (tokens[i].matches("^[-+*/^]$")) {
                if (resultStack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression");
                }
                //pop the last two values from resultStack and apply the operator
                var second = resultStack.pop();
                var first = resultStack.pop();
                switch (tokens[i]) {
                    case "+" -> resultStack.push(first + second);
                    case "-" -> resultStack.push(first - second);
                    case "*" -> resultStack.push(first * second);
                    case "/" -> resultStack.push(first / second);
                    case "^" -> resultStack.push((Math.pow(first, second)));
                }
            }
            System.out.println(resultStack);
            if (resultStack.size() > 1) {
                throw new IllegalArgumentException("Invalid expression...");
            }
        }
        return resultStack.getFirst();
    }
    public static void main(String[] args) {
        String postfixExpression = "10 20 + 30 * +";//900.0
//        String postfixExpression = "10 20 30 * + 40 -";//570
//        String postfixExpression = "2 3 2 ^ ^";//512.0
        System.out.println(evaluatePostfixExpression(postfixExpression));
    }
}
