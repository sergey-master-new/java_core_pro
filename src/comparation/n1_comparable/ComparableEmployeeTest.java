package comparation.n1_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableEmployeeTest {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        Employee emp1 = new Employee(100, "Roman", "Trofimov", 123456);
        Employee emp2 = new Employee(15, "Ivan", "Sidorov", 6542);
        Employee emp3 = new Employee(123, "Ivan", "Petrov", 8542);
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        System.out.println("Before sorting: \n" + employeeList);

//        Если не имплементирован Comparable в классе Employee, компилятор пропускает, будет выброшен Exception в Runtime
//        Arrays.sort(new Employee[] {emp1, emp2, emp3});

//        При сортировке списка объектов - ошибка компилятора, так java не понимает, по какому принципу сортировать
//        Collections.sort(employeeList);
//        Имплементируем Comparable в классе Employee и переопределяем метод compareTo(Employee o)

//        При имплементации Comparable в классе желательно придерживаться естественного порядка - natural order,
//        когда сравниваем по полям класса

        Collections.sort(employeeList);
        System.out.println("After sorting: \n" + employeeList);
    }
}
