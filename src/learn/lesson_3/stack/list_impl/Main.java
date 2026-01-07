package learn.lesson_3.stack.list_impl;

public class Main {
    public static void main(String[] args) {
        ListStack<String> stack = new ListStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        System.out.println(stack);
        System.out.println("Top element: " + stack.peek());
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
