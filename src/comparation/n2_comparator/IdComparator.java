package comparation.n2_comparator;

import java.util.Comparator;

class IdComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {

        if (emp1.getId() == emp2.getId()){
            return 0;
        } else if (emp1.getId() < emp2.getId()){
            return -1;
        } else {
            return 1;
        }

//        Для числовых элементов
//        return emp1.getId() - emp2.getId();
    }
}

