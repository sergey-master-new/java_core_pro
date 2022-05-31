package comparation.n1_comparable;

public class Employee implements Comparable<Employee>{

    private int id;
    private String name;
    private String surname;
    private int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee anotherEmp) {

//        Вариант 1.
//        Классический пример:
//        if (this.getId() == anotherEmp.getId()){
//            return 0;
//        } else if (this.getId() < anotherEmp.getId()){
//            return -1;
//        } else {
//            return 1;
//        }

//        Вариант 2.
//        !!! Чаще всего используется для числовых полей:
//        return this.getId() - anotherEmp.getId();

//        Для объектов типа Integer можно использовать compareTo(),
//        так как public final Integer extends Number implements Comparable<Integer>
//        Если бы id был Integer:
//        return this.id.compareTo(anotherEmp.getId());


//        Для объектов типа String можно использовать compareTo(),
//        так как public public final class String implements java.io.Serializable, Comparable<String>, CharSequence
//        Если бы id был Integer:

        int result = this.name.compareTo(anotherEmp.getName());

        if (result == 0) {

            result = this.surname.compareTo(anotherEmp.getSurname());
        }

        return result;
    }
}
