package learn.lesson_4.implement_queue_using_singly_linkedlist;

public class Main {
    public static void main(String[] args) {
        ListQueue<Integer> queue = new ListQueue<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue);//front [10, 20, 30] rear
        System.out.println(queue.remove());//10
        System.out.println(queue);//Queue: front [20, 30] rear
    }
}
