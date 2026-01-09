package learn.lesson_4.doubly_linkedlist_queue;

import java.util.*;

public class DLQueue<E> implements Queue<E> {

    private LinkedList<E> list = new LinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        for (E e : list) {
            if (e.equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return list.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return list.add(e);
    }

    @Override
    public E remove() {
        if (!isEmpty()) {
            return list.removeFirst();
        }
        throw new NoSuchElementException("Queue is empty");
    }

    @Override
    public E poll() {
        if (!isEmpty()) {
            return list.removeFirst();
        }
        return null;
    }

    @Override
    public E element() {
        if (!isEmpty()) {
            return list.getFirst();
        }
        throw new NoSuchElementException("Queue is empty");
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return list.getFirst();
        }
        return null;
    }

    @Override
    public String toString() {
        return "DLQueue{" +
                "list=" + list +
                '}';
    }
}
