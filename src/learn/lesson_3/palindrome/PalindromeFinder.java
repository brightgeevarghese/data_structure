package learn.lesson_3.palindrome;

import java.util.Stack;

public class PalindromeFinder {
    private final String inputString;
    private final Stack<Character> stack = new Stack<>();
    public PalindromeFinder(String inputString) {
        this.inputString = inputString;
        fillStack();
    }

    private void fillStack() {
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }
    }
    private String buildReverse() {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
    public boolean isPalindrome() {
        return inputString.equals(buildReverse());
    }
}
