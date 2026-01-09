package learn.lesson_4.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addFirst(20);
        deque.addFirst(30);
        System.out.println(deque);//[30, 20, 10]
        deque.clear();
        deque.offer(10);
        deque.offer(20);
        deque.offer(30);
        System.out.println(deque);//[10, 20, 30]
        deque.clear();
        deque.offerLast(10);
        deque.offerLast(20);
        deque.offerLast(30);
        System.out.println(deque);//[10, 20, 30]
        Iterator<Integer> itr = deque.descendingIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next()+" ");//30 20 10
        }
    }
}
