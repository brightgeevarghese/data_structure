package learn.lesson_4.impl_queue_using_circular_array;

public class Main {
    public static void main(String[] args) {
        CircularArrayQueue<Integer> queue = new CircularArrayQueue<>(3);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Queue elements using iterator:");
        for (Integer item : queue) {
            System.out.println(item);
        }
        System.out.println("Printing queue directly (using AbstractQueue's toString which uses iterator):");
        System.out.println(queue);
        queue.add(11);
        queue.add(12);
        queue.add(13);
        System.out.println(queue);
    }
}
