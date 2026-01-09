package learn.lesson_4.doubly_linkedlist_queue;

public class Main {
    public static void main(String[] args) {
        DLQueue<Integer> queue = new DLQueue<>();
        System.out.println(queue.poll());
//        System.out.println(queue.remove());//NoSuchElementException
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);//[10, 20, 30]
        System.out.println(queue.remove());//10
        System.out.println(queue);//[20, 30]
        System.out.println(queue.offer(Integer.valueOf(40)));//true
        System.out.println(queue);//[20, 30, 40]
        System.out.println(queue.poll());//20
        System.out.println(queue);//[30, 40]
    }
}
