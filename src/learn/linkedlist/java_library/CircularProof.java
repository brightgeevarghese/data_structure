package learn.linkedlist.java_library;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class CircularProof {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("First");
        list.add("Middle");
        list.add("Last");

        System.out.println("List: " + list);

        // Proof 1: Iteration has an end
        System.out.println("\nProof 1: Standard Iteration");
        int count = 0;
        for (String s : list) {
            count++;
            System.out.println("Processing: " + s);
        }
        System.out.println("Iteration finished after " + count + " elements. (Circular would loop infinitely if not careful, or at least the iterator would be designed differently)");

        // Proof 2: ListIterator boundaries
        System.out.println("\nProof 2: ListIterator Boundaries");
        ListIterator<String> it = list.listIterator();
        
        // Go to the end
        while(it.hasNext()) {
            it.next();
        }
        
        System.out.print("At the end of the list. hasNext() is: " + it.hasNext());
        try {
            it.next();
        } catch (NoSuchElementException e) {
            System.out.println(" -> Successfully caught NoSuchElementException when calling next() at the end.");
        }

        // Proof 3: Deque behavior
        System.out.println("\nProof 3: Deque Methods");
        System.out.println("peekFirst(): " + list.peekFirst());
        System.out.println("peekLast(): " + list.peekLast());
        
        // In a circular list, logically "after" last is first. 
        // But there is no method in LinkedList that does this automatically.
        // If we remove the last, it doesn't return the first.
    }
}
