package learn.lesson_3.stack.array_impl;

public class Main {
    public static void main(String[] args) {
        ArrayStack<Character> stack = new ArrayStack<>();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');
        stack.push('E');
        stack.push('F');
        stack.push('G');
        stack.push('H');
        stack.push('I');
        stack.push('J');
        stack.push('K');
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}
