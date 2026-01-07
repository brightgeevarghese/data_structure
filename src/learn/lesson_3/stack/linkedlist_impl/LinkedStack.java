package learn.lesson_3.stack.linkedlist_impl;

import learn.lesson_3.stack.EmptyStackException;
import learn.lesson_3.stack.StackOperation;

public class LinkedStack<E> implements StackOperation<E> {
    private Node<E> head;
    @Override
    public E push(E data) {
        Node<E> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        return data;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }
        Node<E> temp = head;
        head = head.next;
        return temp.data;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    class Node<E> {
        E data;
        Node<E> next;
        public Node(E data) {
            this.data = data;
            next = null;
        }
    }
}
