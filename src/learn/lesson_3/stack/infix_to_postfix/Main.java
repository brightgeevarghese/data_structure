package learn.lesson_3.stack.infix_to_postfix;

import java.util.Stack;

public class Main {
    static int precedence(char ch) {
        return switch (ch) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    static boolean rightAssociative(char ch) {
        return ch == '^';
    }

    public static void main(String[] args) {
        test("a^b*c-d/e+f");
        test("(a+b)");
        test("a+b)");
        test("((a+b)-c)");
        test("([a+b])");
        test("([a+b)]");
        test("(a+b");
    }

    static void test(String infix) {
        System.out.println(infix + " -> " + solve(infix));
    }

    static String solve(String infixExp) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfixExp = new StringBuilder();
        for (char ch : infixExp.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfixExp.append(ch);
            } else if (ch == '(' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']') {
                if (stack.isEmpty())
                    return "Invalid Expression";
                char topCh = stack.pop();
                while (topCh != '(' && topCh != '[') {
                    postfixExp.append(topCh);
                    if (stack.isEmpty())
                        return "Invalid Expression";
                    topCh = stack.pop();
                }

                if ((ch == ')' && topCh != '(') || (ch == ']' && topCh != '[')) {
                    return "Invalid Expression";
                }
            } else if ("+-*/^".indexOf(ch) >= 0) {
                while (!stack.isEmpty()
                        && (precedence(ch) < precedence(stack.peek())
                        || precedence(ch) <= precedence(stack.peek()) && (!rightAssociative(ch)))) {
                    postfixExp.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(' || stack.peek() == '[') {
                return "Invalid Expression";
            }
            postfixExp.append(stack.pop());
        }
        return postfixExp.toString();
    }
}
