package comparation.n3_comparable_and_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparationTest {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        Employee emp1 = new Employee(100, "Roman", "Trofimov", 123456);
        Employee emp2 = new Employee(15, "Ivan", "Sidorov", 8542);
        Employee emp3 = new Employee(123, "Ivan", "Petrov", 6542);
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        System.out.println("Before sorting: \n" + employeeList);
        System.out.println("---------------");

        // По умолчанию сортировка по id
        Collections.sort(employeeList);
        System.out.println("After sorting by default (by id): \n" + employeeList);
        System.out.println("---------------");

        Collections.sort(employeeList, new SurnameDescendingComparator());
        System.out.println("After sorting by surname descending: \n" + employeeList);
        System.out.println("---------------");

        // Сортировка по возрастанию по имени
        Collections.sort(employeeList, new Comparator<Employee>(){

            @Override
            public int compare(Employee emp1, Employee emp2) {

                return emp1.getName().compareTo(emp2.getName());
            }
        });
        System.out.println("After sorting by name: \n" + employeeList);
        System.out.println("---------------");

        // Сортировка по возрастанию зарплаты
        Collections.sort(employeeList, (x, y) -> x.getSalary() - y.getSalary());

        System.out.println("After sorting by salary: \n" + employeeList);
        System.out.println("---------------");


    }
}
