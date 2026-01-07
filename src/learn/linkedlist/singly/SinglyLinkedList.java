package learn.linkedlist.singly;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private int size;

    public void addFirst(E data) {
        var newNode = new Node<>(data);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public void addAfter(E data, E afterData) {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        var temp = head;
        while (temp.getNext() != null && !temp.getData().equals(afterData)) {
            temp = temp.getNext();
        }
        if (!temp.getData().equals(afterData)) {
            throw new RuntimeException("Element not found");
        }
        var newNode = new Node<>(data);
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        size++;
    }

    public void addLast(E data) {
        var newNode = new Node<>(data);
        //add it to the end of a linked list
        if (head == null) {
            head = newNode;
            size++;
        } else {
            //traverse till the last node
            var temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            size++;
        }
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    	var temp = head;
    	for(int i = 0; i < index && i < size; i++){
    		temp = temp.getNext();
    	}
    	return temp.getData();
    }

    public void set(int index, E data){
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        var temp = head;
        Node<E> prev = head;
        for (int i = 0; i < index && i < size; i++) {
            prev = temp;
            temp = temp.getNext();
        }
        var node = new Node<>(data);
        prev.setNext(node);
        node.setNext(temp.getNext());
    }

    public E removeFirst() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        var temp = head;
        head = head.getNext();
        size--;
        temp.setNext(null);
        return temp.getData();
    }

    public E removeLast() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        var temp = head;
        if (head.getNext() == null) {
            head = null;
            size--;
        }
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        E data = temp.getNext().getData();
        temp.setNext(null);
        size--;
        return data;
    }

    public E removeAfter(E data) {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        var temp = head;
        while (temp.getNext() != null && !temp.getData().equals(data)) {
            temp = temp.getNext();
        }
        if (temp.getNext() == null && !temp.getData().equals(data)) {
            throw new RuntimeException("Element not found");
        }
        if (temp.getNext() == null && temp.getData().equals(data)) {
            throw new RuntimeException("No node exists after " + data);
        }
        E dataToBeRemoved = temp.getNext().getData();
        temp.setNext(temp.getNext().getNext());
        size--;
        return dataToBeRemoved;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        var temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}
