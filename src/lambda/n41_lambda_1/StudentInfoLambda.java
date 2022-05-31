package lambda.n41_lambda_1;

import java.util.ArrayList;
import java.util.List;

public class StudentInfoLambda {

    void testStudents(List<Student> students, StudentChecks stCheks) {

        for (Student student : students) {

            if (stCheks.check(student)) {
                System.out.println(student);
            }
        }
    }

}

class Test2 {

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

        StudentInfoLambda info = new StudentInfoLambda();
        //ниже не самое лучшее решение, так для одного раза создаем дополнительный класс
        info.testStudents(students, new CheckOverGrade());
        System.out.println("------------");

        //можно использовать анонимный класс
        info.testStudents(students, new StudentChecks() {
            @Override
            public boolean check(Student st) {
                return st.getAge() < 30;
            }
        });
        System.out.println("------------");

        // можно лямбда-выражение.
        // Лямбда-выражение должно соответствовать по входящим параметрам и возвращаемому типу
        // методу check интерфейса StudentChecks
        info.testStudents(students, (Student st) -> {
            return st.getAge() < 30;
        });
        System.out.println("------------");

        //можно лямбда-выражение сделать короче
        info.testStudents(students, st -> st.getAge() < 30);
        System.out.println("------------");

        //avgGrade() > 8
        info.testStudents(students, (Student p) -> {
            return p.getAvgGrade() > 8;
        });
        System.out.println("------------");

        //st.getAge() > age && st.getAvgGrade() < grade && st.getSex() == sex
        info.testStudents(students, (Student p) -> {
            return p.getAge() > 20 && p.getAvgGrade() < 9.3 && p.getSex() == 'f';
        });
        System.out.println("------------");
    }
}

//функциональный интерфейс содержит один абстрактный метод. Дефолтных может быть сколько угодно
interface StudentChecks {

    boolean check(Student st);
}

class CheckOverGrade implements StudentChecks {

    @Override
    public boolean check(Student st) {
        return st.getAvgGrade() > 8;
    }
}
