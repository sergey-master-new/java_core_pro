package lambda.n42_lambda_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentInfoLambda2 {

    void testStudents(List<Student> students, StudentChecks stCheks) {

        for (Student student : students) {

            if (stCheks.check(student)) {
                System.out.println(student);
            }
        }
    }
}

class Test {

    public static void main(String[] args) {

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Marya", 'f', 23, 3, 9.1);

        List<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfoLambda2 info = new StudentInfoLambda2();

//        int p = 3; в этом случае p нельзя будет использовать в лямбда выражениях

        //age < 30
        StudentChecks studentChecks = p -> p.getAge() < 30;
        info.testStudents(students, studentChecks);
        System.out.println("------------");

        //avgGrade > 8
        info.testStudents(students, p -> p.getAvgGrade() > 8);
        System.out.println("------------");

        //age > 20 && avgGrade < 9.3 && sex == 'f'
        info.testStudents(students, p -> p.getAge() > 20 && p.getAvgGrade() < 9.3 && p.getSex() == 'f');
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

//функциональный интерфейс содержит один абстрактный метод. Дефолтных может быть сколько угодно
interface StudentChecks {

    boolean check(Student st);
}
