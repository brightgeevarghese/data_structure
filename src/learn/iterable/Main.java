package learn.iterable;

import java.util.*;

public class Main {
    /**
     * Removes elements divisible by divisor from list
     */
    public static void removeDivisibleBy(LinkedList<Integer> list, int divisor) {
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            if (itr.next() % divisor == 0) {
                itr.remove();
            }
        }
    }
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        LinkedList<Integer> list = new LinkedList<>(numbers);
        System.out.println(list);
        removeDivisibleBy(list, 2);
        System.out.println(list);
        System.out.println(numbers);
        removeDivisibleBy(list, 3);
        System.out.println(list);
//        Iterator<Integer> itr = numbers.iterator();
//        while (itr.hasNext()) {
//            System.out.println(itr.next());
////            itr.remove();
//        }
//        System.out.println(numbers);
    }
}

class IteratorVsListIterator {

    public static void main(String[] args) {
        System.out.println("=== Iterator vs ListIterator Comparison ===\n");

        // Create a sample list
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        list.add("Elderberry");

        System.out.println("Original List: " + list + "\n");

        // ========== ITERATOR DEMONSTRATION ==========
        System.out.println("--- ITERATOR (Forward only) ---");
        demonstrateIterator(list);

        System.out.println("\n--- LISTITERATOR (Bidirectional) ---");
        demonstrateListIterator(list);

        System.out.println("\n--- KEY DIFFERENCES SUMMARY ---");
        printDifferences();
    }

    /**
     * Demonstrates Iterator capabilities
     */
    public static void demonstrateIterator(List<String> list) {
        Iterator<String> iterator = list.iterator();

        System.out.println("1. Forward traversal:");
        while (iterator.hasNext()) {
            System.out.println("   - " + iterator.next());
        }

        // Note: Iterator cannot go backward
        System.out.println("\n2. Iterator limitations:");
        System.out.println("   - Cannot traverse backward (no hasPrevious() or previous())");
        System.out.println("   - Cannot get index (no nextIndex() or previousIndex())");
        System.out.println("   - Cannot add elements (no add() method)");
        System.out.println("   - Can only remove elements using remove()");

        // Demonstrate remove
        Iterator<String> iterator2 = list.iterator();
        System.out.println("\n3. Removing elements with Iterator:");
        while (iterator2.hasNext()) {
            String item = iterator2.next();
            if (item.equals("Cherry")) {
                iterator2.remove();
                System.out.println("   - Removed: " + item);
            }
        }
        System.out.println("   List after removal: " + list);

        // Restore the list
        list.add(2, "Cherry");
    }

    /**
     * Demonstrates ListIterator capabilities
     */
    public static void demonstrateListIterator(List<String> list) {
        ListIterator<String> listIterator = list.listIterator();

        System.out.println("1. Forward traversal:");
         while (listIterator.hasNext()) {
             int index = listIterator.nextIndex();
             String item = listIterator.next();
             System.out.println("   - Index " + index + ": " + item);
         }

        System.out.println("\n2. Backward traversal:");
        while (listIterator.hasPrevious()) {
            int index = listIterator.previousIndex();
            String item = listIterator.previous();
            System.out.println("   - Index " + index + ": " + item);
        }

        System.out.println("\n3. Adding elements with ListIterator:");
        listIterator = list.listIterator(2); // Start at index 2
        listIterator.next(); // Move to "Cherry"
        listIterator.add("Coconut");
        System.out.println("   - Added 'Coconut' after 'Cherry'");
        System.out.println("   List after addition: " + list);

        System.out.println("\n4. Setting (replacing) elements with ListIterator:");
        listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            if (item.equals("Banana")) {
                listIterator.set("Blueberry");
                System.out.println("   - Replaced 'Banana' with 'Blueberry'");
            }
        }
        System.out.println("   List after replacement: " + list);

        System.out.println("\n5. Getting current index:");
        listIterator = list.listIterator(3);
        System.out.println("   - Current nextIndex(): " + listIterator.nextIndex());
        System.out.println("   - Current previousIndex(): " + listIterator.previousIndex());
    }

    /**
     * Prints a summary of key differences
     */
    public static void printDifferences() {
        System.out.println("┌──────────────────────────────────────────────────────┐");
        System.out.println("│ Feature                    │ Iterator │ ListIterator │");
        System.out.println("├──────────────────────────────────────────────────────┤");
        System.out.println("│ Forward traversal          │    ✓     │      ✓       │");
        System.out.println("│ Backward traversal         │    ✗     │      ✓       │");
        System.out.println("│ Get next index             │    ✗     │      ✓       │");
        System.out.println("│ Get previous index         │    ✗     │      ✓       │");
        System.out.println("│ Remove elements            │    ✓     │      ✓       │");
        System.out.println("│ Add elements               │    ✗     │      ✓       │");
        System.out.println("│ Set/Replace elements       │    ✗     │      ✓       │");
        System.out.println("│ Works with Collection      │    ✓     │      ✗       │");
        System.out.println("│ Works with List only       │    ✓     │      ✓       │");
        System.out.println("│ Start at specific index    │    ✗     │      ✓       │");
        System.out.println("└──────────────────────────────────────────────────────┘");

        System.out.println("\nKEY POINTS:");
        System.out.println("1. Iterator: Basic interface for forward-only traversal");
        System.out.println("   - Available for all Collection implementations");
        System.out.println("   - Can only remove elements");
        System.out.println("   - Simpler and more lightweight");

        System.out.println("\n2. ListIterator: Extended interface for List collections");
        System.out.println("   - Bidirectional traversal (forward and backward)");
        System.out.println("   - Can add, set, and remove elements");
        System.out.println("   - Provides index information");
        System.out.println("   - Can start iteration at any position");
        System.out.println("   - Only available for List implementations");
    }
}

