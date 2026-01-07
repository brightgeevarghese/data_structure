package learn.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Sanjay", 20);
        Employee emp2 = new Employee("Jane", 25);
        System.out.println(emp1.compareTo(emp2));
        System.out.println(emp2.compareTo(emp1));
        List<Employee> empList = new ArrayList<>(List.of(emp1, emp2));
        Collections.sort(empList);
        System.out.println(empList);
    }
}
