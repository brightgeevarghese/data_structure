package learn.lesson_3.stack.array_impl;

import learn.lesson_3.stack.EmptyStackException;
import learn.lesson_3.stack.StackOperation;

import java.util.Arrays;

public class ArrayStack<E> implements StackOperation<E> {
    private E[] data;
    private final int INITIAL_CAPACITY = 10;
    private int topOfStack = -1;
    public ArrayStack() {
        this.data = (E[]) new Object[INITIAL_CAPACITY];
    }
    @Override
    public E push(E data) {
        if (topOfStack == this.data.length - 1) {
            reallocate();
            this.data[++topOfStack] = data;
        } else {
            this.data[++topOfStack] = data;
        }
        return data;
    }

    private void reallocate() {
        E[] newData = (E[]) new Object[this.data.length * 2];
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        this.data = newData;
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            return this.data[topOfStack--];
        }
        throw new EmptyStackException("Stack is empty");
    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return this.data[topOfStack];
        }
        throw  new EmptyStackException("Stack is empty");
    }

    @Override
    public boolean isEmpty() {
        return topOfStack == -1;
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "data=" + Arrays.toString(Arrays.copyOf(data, topOfStack + 1)) +
                '}';
    }
}
