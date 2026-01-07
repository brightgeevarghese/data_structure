package learn.linkedlist.singly;

public class Main {
    public static void main(String[] args) {
        var list = new SinglyLinkedList<Integer>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
//        list.display();
//        System.out.println("\nSize of the list is " + list.getSize());
//        System.out.println(list.get(1));
//        list.addFirst(55);
//        list.addFirst(56);
//        list.addLast(57);
//        list.display();//56 55 10 20 30 57
//        list.addAfter(20, 30);
//        list.display();
//        list.addAfter(201, 20);
//        list.display();
//        list.removeFirst();
//        list.display();
//        list.removeLast();
        list.display();
//        list.removeAfter(10);
//        list.display();
        list.set(2, 100);
        list.display();
    }
}
