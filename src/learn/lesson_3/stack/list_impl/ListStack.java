package learn.lesson_3.stack.list_impl;

import learn.lesson_3.stack.EmptyStackException;
import learn.lesson_3.stack.StackOperation;

import java.util.ArrayList;
import java.util.List;

public class ListStack<E> implements StackOperation<E> {
    private List<E> list;

    public ListStack() {
        this.list = new ArrayList<>();
    }

    @Override
    public E push(E data) {
        list.add(data);
        return data;
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            return list.remove(list.size() - 1);
        }
        throw new EmptyStackException("Stack is empty");
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return list.getLast();
        }
        throw new EmptyStackException("Stack is empty");
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "ListStack{" +
                "list=" + list +
                '}';
    }
}
