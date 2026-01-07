package learn.lesson_3.balanced_paranthesis;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String inputString = "[(a + b) * (c / d)]))";
        for (char ch : inputString.toCharArray()) {
            // Determines balanced status by matching bracket pairs
            if (ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == ']') {
                if (!stack.isEmpty()) {
                    if (stack.peek() != '[') {
                        System.out.println("Not balanced");
                        return;
                    } else if (stack.peek() == '['){
                        stack.pop();
                    }
                } else {
                    System.out.println("Not balanced");
                    return;
                }
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    if (stack.peek() != '(') {
                        System.out.println("Not balanced");
                    } else if (stack.peek() == '('){
                        stack.pop();
                    }
                } else {
                    System.out.println("Not balanced");
                    return;
                }
            }
        }
        System.out.println(stack);
        System.out.println(stack.isEmpty());
    }
}
