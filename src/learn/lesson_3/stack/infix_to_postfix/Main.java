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

            // 1) Operand
            if (Character.isLetterOrDigit(ch)) {
                postfixExp.append(ch);
            }

            // 2) Opening brackets
            else if (ch == '(' || ch == '[') {
                stack.push(ch);
            }

            // 3) Closing brackets
            else if (ch == ')' || ch == ']') {
                char open = (ch == ')') ? '(' : '[';

                // Pop operators until we reach the matching opener
                while (!stack.isEmpty() && stack.peek() != open) {
                    // If we hit the other type of opener first => mismatch like ([a+b)]
                    if (stack.peek() == '(' || stack.peek() == '[') {
                        return "Invalid Expression";
                    }
                    postfixExp.append(stack.pop());
                }

                // No matching opener found
                if (stack.isEmpty()) {
                    return "Invalid Expression";
                }

                // Pop the matching opener
                stack.pop();
            }

            // 4) Operator
            else if ("+-*/^".indexOf(ch) >= 0) {
                while (!stack.isEmpty()
                        && stack.peek() != '(' && stack.peek() != '['
                        && (precedence(stack.peek()) > precedence(ch)
                        || (precedence(stack.peek()) == precedence(ch) && !rightAssociative(ch)))) {
                    postfixExp.append(stack.pop());
                }
                stack.push(ch);
            }

            // 5) Ignore spaces (optional). If you want to reject unknown chars, return invalid instead.
            else if (Character.isWhitespace(ch)) {
                continue;
            } else {
                return "Invalid Expression";
            }
        }

        // 6) Pop remaining operators
        while (!stack.isEmpty()) {
            if (stack.peek() == '(' || stack.peek() == '[') {
                return "Invalid Expression";
            }
            postfixExp.append(stack.pop());
        }

        return postfixExp.toString();
    }
}
