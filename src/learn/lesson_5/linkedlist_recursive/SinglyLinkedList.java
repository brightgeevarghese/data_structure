package learn.lesson_5.linkedlist_recursive;

public class SinglyLinkedList<E> {
    private class Node {
        private final E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }
    }
    private Node head;

    /***
     * Add a new node at the end of the list
     * @param data The data to be added
     */
    public void add(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            add(head, newNode);
        }
    }

    /***
     * A helper method to add node at the end of the list
     * @param current The current node
     * @param newNode The new node to be added
     */
    private void add(Node current, Node newNode) {
        if (current.next == null) {
            current.next = newNode;
        } else {
            add(current.next, newNode);
        }
    }

    /***
     * Display the list
     */
    public void display() {
        System.out.println("Displaying the list");
        if (head == null) {
            System.out.println("List is empty");
        } else {
            display(head);
        }
    }

    /***
     * A helper method to display the list
     * @param current The current node
     */
    private void display(Node current) {
        if (current == null) {
            return;
        } else {
            System.out.print(current.data + " ");
            display(current.next);
        }
    }
}
