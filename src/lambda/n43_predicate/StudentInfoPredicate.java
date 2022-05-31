package lambda.n43_predicate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StudentInfoPredicate {

    void testStudents(List<Student> students, Predicate<Student> predicateStud) {

        for (Student student : students) {

            if (predicateStud.test(student)) {
                System.out.println(student);
            }
        }
    }
}

class TestPredicate {

    public static void main(String[] args) {

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Marya", 'f', 23, 3, 7.1);

        List<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfoPredicate info = new StudentInfoPredicate();

//        int p = 3; в этом случае p нельзя будет использовать в лямбда выражениях переменную p

        //age < 30
        Predicate<Student> predicateStudCheck = p -> p.getAge() < 30;
        info.testStudents(students, predicateStudCheck);
        System.out.println("------------");

        Predicate<Student> predicate2 = p -> p.getAvgGrade() > 7.5;
        Predicate<Student> predicate3 = p -> p.getSex() == 'm';

        //avgGrade > 7.5
        info.testStudents(students, predicate2);
        System.out.println("------------");

        //avgGrade > 7.5 && sex == 'm' используется and
        info.testStudents(students, predicate2.and(predicate3));
        System.out.println("------------");

        //avgGrade > 7.5 && sex == 'm' используется or /или
        info.testStudents(students, predicate2.or(predicate3));
        System.out.println("------------");

        //avgGrade > 7.5 negate() - не соответствует
        info.testStudents(students, predicate2.negate());
        System.out.println("------------");


        //сортировка
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getCourse() - s2.getCourse();
            }
        });
        System.out.println(students);
        System.out.println("------------");

        //сортировка2 по убыванию
        Collections.sort(students, (s1, s2) -> s2.getCourse() - s1.getCourse());
        System.out.println(students);
        System.out.println("------------");
    }
}


