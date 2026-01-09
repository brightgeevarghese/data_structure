package learn.lesson_4.customer_queue;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class MaintainQueue {
    private Queue<String> customers;
    public MaintainQueue() {
        this.customers = new LinkedList<>();
    }

    public void processCustomers() {
        int choiceNumber = 0;
        String []choices = {
                "add", "peek", "remove", "size", "position", "quit"
        };
        while (choiceNumber < choices.length-1) {
            choiceNumber = JOptionPane.showOptionDialog(
                    null,
                    "Select an operation on customer queue",
                    "Queue Menu",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choices,
                    choices[0]
            );
            switch (choiceNumber) {
                case 0 -> customers.add(JOptionPane.showInputDialog("Enter customer name"));
                case 1 -> {
                    if (customers.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Queue is empty");
                    }
                    JOptionPane.showMessageDialog(null, "First customer in queue is " + customers.peek());
                }
                case 2 -> customers.remove();
                case 3 -> JOptionPane.showMessageDialog(null, "Queue size is " + customers.size());
                //show position
                case 4 -> {
                    String name = JOptionPane.showInputDialog("Enter customer name");
                    int count = 0;
                    boolean found = false;
                    for (String customer : customers) {
                        count++;
                        if (customer.equals(name)) {
                            JOptionPane.showMessageDialog(null, name + " is at position " + count);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, name + " is not in the queue");
                    }
                }
                case 5 -> JOptionPane.showMessageDialog(null, "Goodbye!");
            }
            if (choiceNumber == -1 || choices[choiceNumber].equals("quit")) break;
        }
    }
}
