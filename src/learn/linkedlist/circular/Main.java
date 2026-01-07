package learn.linkedlist.circular;

public class Main {
    public static void main(String[] args) {
        CircularLinkedList<Integer> list = new CircularLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addFirst(50);
        System.out.println("Display forward:");
        list.displayForward();
        System.out.println("Display backward:");
        list.displayBackward();
        list.addLast(60);
        list.addLast(70);
        list.addLast(80);
        System.out.println("Display forward:");
        list.displayForward();
        System.out.println("Display backward:");
        list.displayBackward();
        list.addAfter(11, 50);
        list.displayForward();
        list.displayBackward();
//        System.out.println("Display forward:");
//        list.displayForward();
        list.addAfter(99, 80);
        System.out.println("Display forward:");
        list.displayForward();
        list.removeData(20);
        System.out.println("Display forward:");
        list.displayForward();
        System.out.println("Display backward:");
        list.displayBackward();
    }
}
