package learn.enhanced_for;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> orders = new LinkedList<>(
                List.of("Apple", "Banana", "Apple", "Mango", "Apple", "Orange", "Banana")
        );
        //How many students ordered Apple?
        int count = 0;
        //Using Iterator
        Iterator<String> itr = orders.iterator();
        while (itr.hasNext()) {
            if (itr.next().equals("Apple")) {
                count++;
            }
        }
        System.out.println("Number of students who ordered Apple: " + count);
        count = 0;
        //Using enhanced for
        for (String order : orders) {
            if (order.equals("Apple")) {
                count++;
            }
        }
        System.out.println("Number of students who ordered Apple: " + count);
    }
}
