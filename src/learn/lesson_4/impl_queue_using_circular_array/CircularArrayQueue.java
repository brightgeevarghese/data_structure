package learn.lesson_4.impl_queue_using_circular_array;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

public class CircularArrayQueue<E> extends AbstractQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    public CircularArrayQueue(int initCapacity) {
        this.data = (E[]) new Object[initCapacity];
        capacity = initCapacity;
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {
        private int index;
        private int count;
        public Iter() {
            index = front;
        }

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E item = data[index];
                index = (index + 1) % capacity;
                count++;
                return item;
            }
            throw new IndexOutOfBoundsException("No more elements");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E e) {
        if (size == capacity) {
            reallocate();
        }
        rear = (rear + 1) % capacity;
        data[rear] = e;
        size++;
        return true;
    }

    private void reallocate() {
        E[] newData = (E[]) new Object[capacity * 2];
        int index = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[index];
            index = (index + 1) % capacity;
        }
        data = newData;
        front = 0;
        rear = size - 1;
        capacity *= 2;
    }

    @Override
    public E poll() {
        if (size > 0) {
            E item = data[front];
            data[front] = null;
            front = (front + 1) % capacity;
            size--;
            return item;
        }
        return null;
    }

    @Override
    public E peek() {
        if (size > 0) {
            return data[front];
        }
        return null;
    }


}
