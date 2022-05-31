package comparation.n2_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorEmployeeTest {

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

        //Добавляем объект компаратора
        Collections.sort(employeeList, new IdComparator());
        System.out.println("After sorting by id: \n" + employeeList);
        System.out.println("---------------");

        Collections.sort(employeeList, new NameComparator());
        System.out.println("After sorting by name: \n" + employeeList);
        System.out.println("---------------");

        Collections.sort(employeeList, new SalaryComparator());
        System.out.println("After sorting by salary: \n" + employeeList);
        System.out.println("---------------");

    }
}
