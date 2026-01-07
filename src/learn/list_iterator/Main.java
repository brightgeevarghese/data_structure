package learn.list_iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        ListIterator<Integer> itr = list.listIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        //Traverse reversal
        System.out.println("Traversal in reverse order:");
        while (itr.hasPrevious()) {
            System.out.println(" - index " + itr.previousIndex() + ": " + itr.previous());
        }
        System.out.println("//Add an element after 30");
        while (itr.hasNext()) {
            if (itr.next().equals(30)) {
                itr.add(35);
            }
        }
        //Go to the beginning
        itr = list.listIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        //Display the previous element
        System.out.println("Previous: " + itr.previous());
        itr.add(111);
        //Forward
        System.out.println("Forward traversal:");
        itr = list.listIterator();
        while (itr.hasNext()) {
            System.out.println("- index " + itr.nextIndex() + ": " + itr.next());
        }
        //Go to the beginning
        itr = list.listIterator();
        itr = list.listIterator(2);
        System.out.println("Forward traversal:");
        while (itr.hasNext()) {
            System.out.println("- index " + itr.nextIndex() + ": " + itr.next());
        }

    }
}
