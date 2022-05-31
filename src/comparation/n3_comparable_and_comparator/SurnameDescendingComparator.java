package comparation.n3_comparable_and_comparator;

import java.util.Comparator;

public class SurnameDescendingComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {

        if (emp1.getSurname() == emp2.getSurname()){
            return 0;
        } else if (emp1.getSurname().compareTo(emp2.getSurname()) == 1){
            return -1;
        } else {
            return 1;
        }
    }
}
