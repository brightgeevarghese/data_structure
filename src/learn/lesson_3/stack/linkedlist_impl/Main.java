package learn.lesson_3.stack.linkedlist_impl;

public class Main {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        System.out.println("Top element: " + stack.peek());
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
