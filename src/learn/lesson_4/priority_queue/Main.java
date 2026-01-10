package learn.lesson_4.priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Employee> queue = new PriorityQueue<>(
                new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return Double.compare(o2.salary, o1.salary);
                    }
                }
        );
        queue.add(new Employee("A", 1000, "a@gmail.com"));
        queue.add(new Employee("B", 1500, "b@gmail.com"));
        queue.add(new Employee("C", 900, "c@gmail.com"));
        queue.add(new Employee("D", 1200, "d@gmail.com"));
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

class Employee {
    String name;
    double salary;
    String email;

    public Employee(String name, double salary, String email) {
        this.name = name;
        this.salary = salary;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                '}';
    }
}

/***
 * It creates a min-heap tree
 * Root of the heap = minimum salary
 * Double.compare(o1.salary, o2.salary);
 * [Employee{name='C', salary=900.0, email='c@gmail.com'}, Employee{name='D', salary=1200.0, email='d@gmail.com'}, Employee{name='A', salary=1000.0, email='a@gmail.com'}, Employee{name='B', salary=1500.0, email='b@gmail.com'}]
 * Employee{name='C', salary=900.0, email='c@gmail.com'}
 * Employee{name='A', salary=1000.0, email='a@gmail.com'}
 * Employee{name='D', salary=1200.0, email='d@gmail.com'}
 * Employee{name='B', salary=1500.0, email='b@gmail.com'}
 */

/***
 * It creates a max-heap tree
 * Root of the heap = maximum salary
 * Double.compare(o2.salary, o1.salary)
 * [Employee{name='B', salary=1500.0, email='b@gmail.com'}, Employee{name='D', salary=1200.0, email='d@gmail.com'}, Employee{name='C', salary=900.0, email='c@gmail.com'}, Employee{name='A', salary=1000.0, email='a@gmail.com'}]
 * Employee{name='B', salary=1500.0, email='b@gmail.com'}
 * Employee{name='D', salary=1200.0, email='d@gmail.com'}
 * Employee{name='A', salary=1000.0, email='a@gmail.com'}
 * Employee{name='C', salary=900.0, email='c@gmail.com'}
 */