package regexp.n114_printf;

public class PrintfExample1 {

    private static void printEmployeeInfo(Employee emp){

        System.out.printf("%03d \t %-12s \t %-12s \t %,.1f \n",                               // идея предлагает \n = %n
                emp.getId(), emp.getName(), emp.getSurname(), emp.getSalary()*(1 + emp.getBonus()));
    }

    public static void main(String[] args) {

        Employee employee1 = new Employee(1, "Roman", "Romanov", 1000, 0.2);
        Employee employee2 = new Employee(2, "Igor", "Egorov", 2000, 0.3);
        Employee employee3 = new Employee(3, "Yan", "Yanov", 8123, 0.4);

        printEmployeeInfo(employee1);
        printEmployeeInfo(employee2);
        printEmployeeInfo(employee3);

        String employeeString = String.format("Employee: %03d \t %-10s \t %-10s \t %,.1f %n",
                1, "Vasya", "Vasiliev", 12345*(1 + 0.2));

        System.out.println("Format example");
        System.out.println(employeeString);
    }
}

class Employee{

    private int id;
    private String name;
    private String surname;
    private int salary;
    private double bonus;

    public Employee(int id, String name, String surname, int salary, double bonus) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }
}