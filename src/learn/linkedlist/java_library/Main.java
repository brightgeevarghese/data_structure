package learn.linkedlist.java_library;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // java.util.LinkedList is a Doubly Linked List implementation
        LinkedList<String> list = new LinkedList<>();

        // Adding elements
        list.add("Apple");
        list.add("Banana");
        list.addFirst("Cherry");
        list.addLast("Date");

        System.out.println("Current LinkedList: " + list);

        // Removing elements
        list.removeFirst();
        list.removeLast();

        System.out.println("After removals: " + list);

        // Accessing elements
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println("Element at index 1: " + list.get(1));

        // Characteristics:
        // 1. It is a DOUBLY linked list.
        // 2. It can be used as a List, Stack (via push/pop), or Queue (via offer/poll).
        // 3. It is NOT circular by default.
        // 4. It is NOT a singly linked list (it maintains pointers to both next and previous).

        //current list
        System.out.println("Current list:");
        System.out.println(list);
        //Retrieve the last node
        System.out.println("Last node:");
        System.out.println(list.peekLast());
        //display the list from last to first
        System.out.println("In reverse order:");
        Iterator<String> iterator = list.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println(list.remove(1));
        System.out.println("Current list:");
        System.out.println(list);
    }
}
