package learn.lesson_4.implement_queue_using_singly_linkedlist;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

public class ListQueue<E> extends AbstractQueue<E> implements Queue<E> {
    class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    private Node front;
    private Node rear;
    private int size;

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    /***
     * Add an element at the rear of the queue
     * @param e the element to add
     * @return true if the element was added successfully, false otherwise
     */
    @Override
    public boolean offer(E e) {
        if (front == null) {
            front = rear = new Node(e);
        } else {
            rear.next = new Node(e);
            rear = rear.next;
        }
        size++;
        return true;
    }

    @Override
    public E poll() {
        E item = peek();
        if (item != null) {
            front = front.next;
            size--;
            return item;
        }
        return null;
    }

    @Override
    public E peek() {
        if (size() == 0) {
            return null;
        }
        return front.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front [");
        var temp = front;
        for (int i = 0; i < size(); i++) {
            sb.append(temp.data).append(", ");
            temp = temp.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("] rear");
        return sb.toString();
    }
}
