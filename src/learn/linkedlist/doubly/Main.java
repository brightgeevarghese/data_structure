package learn.linkedlist.doubly;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(15);
        list.displayForward();
        list.addAfter(222, 15);
        list.displayForward();
        System.out.print("Display backward: ");
        list.displayBackward();
        System.out.println("Display forward:");
        list.displayForward();
//        System.out.println(list.removeFirst() + " is removed from the list");
//        System.out.println(list.removeFirst() + " is removed from the list");
//        System.out.println(list.removeFirst() + " is removed from the list");
//        System.out.println(list.removeFirst() + " is removed from the list");
//        System.out.println(list.removeFirst() + " is removed from the list");
//        System.out.println(list.removeFirst() + " is removed from the list"); // throws exception
        list.displayForward();
//        System.out.println(list.removeLast() + " is removed from the list");
//        System.out.println(list.removeLast() + " is removed from the list");
//        System.out.println(list.removeLast() + " is removed from the list");
//        System.out.println(list.removeLast() + " is removed from the list");
//        System.out.println(list.removeLast() + " is removed from the list");
        list.displayForward();
        list.removeData(222);
        list.displayForward();
    }
}
