package learn.linkedlist.doubly;

public class DoublyLinkedList<E> {
    private Node<E> head;
    private int size;
    private Node<E> tail;

    public void addFirst(E data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
        } else {
            var newNode = new Node<>(data);
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addAfter(E data, E afterData) {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node<E> temp = head;
            // Advances cursor until match or end is found
            while (temp.getNext() != null && !temp.getData().equals(afterData)) {
                temp = temp.getNext();
            }
            if (temp.getNext() == null) {
                System.out.println("Element not found");
                return;
            }
            // Inserts node after matched element if found
            if (temp.getNext() != null) {
                var newNode = new Node<>(data);
                newNode.setNext(temp.getNext());
                newNode.setPrev(temp);
                temp.getNext().setPrev(newNode);
                temp.setNext(newNode);
            } else if (temp.getNext() == null && temp.getData().equals(afterData)) {
                addLast(data);
            } else {
                System.out.println("Element not found");
            }
        }
    }

    public void addLast(E data) {
        if (head == null) {
            head = new Node<>(data);
        }  else {
            var newNode = new Node<>(data);
            Node<E> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrev(temp);
            tail = newNode;
        }
    }

    /**
     * Removes and returns the first element; adjusts pointers
     */
    public E removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        E data = head.getData();
        head = head.getNext();
        if (head != null) {
            head.setPrev(null);
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    public E removeLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        E data = tail.getData();
        tail = tail.getPrev();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
        size--;
        return data;
    }

    public E removeData(E data) {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        if (head.getData().equals(data)) {
            return removeFirst();
        }
        Node<E> temp = head;
        while (temp.getNext() != null && !temp.getData().equals(data)) {
            temp = temp.getNext();
        }
        // Removes an element if found; throws if not
        if (temp.getData().equals(data) && temp.getNext() == null) {
            return removeLast();
        } else if (temp.getData().equals(data) && temp.getNext() != null) {
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            return data;
        } else {
            throw new RuntimeException("Element not found");
        }
    }

    /**
     * Prints data of each node in the list
     */
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
        }
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node<E> temp = tail;
            while (temp != null) {
                System.out.print(temp.getData() + " ");
                temp = temp.getPrev();
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }
}
