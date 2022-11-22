package reflection;

import java.lang.reflect.Field;

public class ReflectionExample3 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Employee employee = new Employee(5, "Roman", "IT");
        Class employeeClass = employee.getClass();
        Field field = employeeClass.getDeclaredField("salary"); //с маленькой буквы
        field.setAccessible(true);
        double salaryValue = (double) field.get(employee);
        System.out.println(employee);

        field.set(employee, 1500);
        System.out.println(employee);
    }
}
