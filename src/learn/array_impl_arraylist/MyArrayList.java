package learn.array_impl_arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

/***
 * This class implements some of the methods of the Java ArrayList class
 * @param <E> - Generic type
 */
public class MyArrayList<E> {
    public static final int INITIAL_CAPACITY = 5;
    //underlying data array
    private E[] data;
    //current size of the array
    private int size = 0;
    //current capacity of the array
    private int capacity = 0;

    /***
     * Constructor for MyArrayList
     */
    public MyArrayList() {
        capacity = INITIAL_CAPACITY;
        data = (E[]) new Object[capacity];
    }

    /***
     * Adds an element to the end of the array
     * @param element - element to be added
     */
    public void add(E element) {
        // Ensure there is enough capacity; grow if necessary
        if (size == capacity) {
            int newCapacity = (capacity == 0) ? INITIAL_CAPACITY : capacity * 2;
            @SuppressWarnings("unchecked")
            E[] newData = (E[]) new Object[newCapacity];
            if (data != null && size > 0) {
                System.arraycopy(data, 0, newData, 0, size);
                System.out.println("size is doubled and copied from old array to new array");
            }
            data = newData;
            capacity = newCapacity;
        }

        // Add the new element and increase the size
        data[size++] = element;
    }

    /***
     * Adds an element at a specified index
     * @param index - index at which the element is to be added
     * @param element - element to be added
     */
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == capacity) {
            int newCapacity = (capacity == 0) ? INITIAL_CAPACITY : capacity * 2;
            @SuppressWarnings("unchecked")
            E[] newData = (E[]) new Object[newCapacity];
            if (data != null && size > 0) {
                System.arraycopy(data, 0, newData, 0, index);
                System.arraycopy(data, index, newData, index + 1, size - index);
            }
        } else {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = element;
        size++;
    }

    /***
     * Returns the element at the specified index
     * @param index - index of the element to be returned
     * @return E - element at the specified index
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return data[index];
    }

    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = data[index];
        data[index] = element;
        return oldValue;
    }
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        System.out.println("b4 setting null: "+Arrays.toString(data));
        data[size - 1] = null;
        System.out.println("after setting null: "+ Arrays.toString(data));
        size--;
        return oldValue;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size && data[i] != null; i++) {
            sb.append(data[i]).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return "[" + sb + ']';
    }
}

class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        System.out.println(myArrayList);
        myArrayList.add(4);
        myArrayList.add(5);
        System.out.println(myArrayList);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);
        System.out.println(myArrayList);
        myArrayList.add(1,10);
        System.out.println(myArrayList);
        System.out.println("Element at position/index 2: " + myArrayList.get(2));
        System.out.println("Set element at position/index 2: " + myArrayList.set(2, 100));
        System.out.println(myArrayList);
        myArrayList.remove(2);
        System.out.println(myArrayList);
    }
}
