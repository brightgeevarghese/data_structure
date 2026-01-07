package learn.linkedlist.circular;

public class CircularLinkedList<E> {
    private Node<E> head;
    private int size;

    public void addFirst(E data) {
        if (head == null) {
            head = new Node<>(data);
            head.setNext(head);
            head.setPrev(head);
        } else {
            var newNode = new Node<>(data);
            newNode.setNext(head);
            //var tail = head.getPrev();
            if (head.getNext().equals(head)) {
                newNode.setPrev(head);
                head.setNext(newNode);
                head.setPrev(newNode);
            } else {
                newNode.setPrev(head.getPrev());
                head.getPrev().setNext(newNode);
                head.setPrev(newNode);
            }
            head = newNode;
        }
        size++;
    }

    public void addAfter(E data, E afterData) {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            var temp = head;
            while (temp.getNext() != head && !temp.getData().equals(afterData)) {
                temp = temp.getNext();
            }
            var newNode = new Node<>(data);
            // Inserts node after target; updates links
            if (temp.getData().equals(afterData)) {
                newNode.setNext(temp.getNext());
                newNode.setPrev(temp);
                temp.setNext(newNode);
                newNode.getNext().setPrev(newNode);
                size++;
            } else {
                System.out.println("Element not found");
            }
        }
    }

    public void addLast(E data) {
        if (head == null) {
            head = new Node<>(data);
            head.setNext(head);
            head.setPrev(head);
        }  else {
            var newNode = new Node<>(data);
            head.getPrev().setNext(newNode);
            newNode.setPrev(head.getPrev());
            newNode.setNext(head);
            head.setPrev(newNode);
        }
        size++;
    }

    /**
     * Removes and returns the first element; adjusts pointers
     */
    public E removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        if (head.getNext() == head) {
            var node = head;
            head = null;
            size--;
            return node.getData();
        }
        var temp = head;
        var data = head.getData();
        var tail = head.getPrev();
        tail.setNext(head.getNext());
        head.getNext().setPrev(tail);
        head = head.getNext();
        temp.setNext(null);
        temp.setPrev(null);
        size--;
        return data;
    }

    public E removeLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        var tail = head.getPrev();
        var data = tail.getData();
        head.setPrev(tail.getPrev());
        tail.getPrev().setNext(head);
//        tail.setNext(null);
//        tail.setPrev(null);
        size--;
        return data;
    }

    public E removeData(E data) {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        //case 1: head
        if (head.getData().equals(data)) {
            return removeFirst();
        }
        //search
        var temp = head;
        while (temp.getNext() != head && !temp.getData().equals(data)) {
            temp = temp.getNext();
        }
        //case 2: tail
        if (head.getPrev() == temp && temp.getData().equals(data)) {
            return removeLast();
        }
        if (temp.getData().equals(data)) {
            var prev = temp.getPrev();
            var next = temp.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            size--;
            return temp.getData();
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
            return;
        }
        Node<E> temp = head;
        do {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        } while (temp != head);
        System.out.println();
    }

    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            var tail = head.getPrev();
            do {
                System.out.print(tail.getData() + " ");
                tail = tail.getPrev();
            } while (tail != head);
            if (size > 1) {
                System.out.print(tail.getData() + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }
}
