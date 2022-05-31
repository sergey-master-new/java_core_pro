package lambda.n41_lambda_1;

import java.util.ArrayList;
import java.util.List;

public class StudentInfo {

    void printStudentsOverGrade(List<Student> students, double grade) {

        for (Student st: students) {

            if (st.getAvgGrade() > grade){
                System.out.println(st);
            }
        }
    }

    void printStudentsUnderAge(List<Student> students, int age) {

        for (Student st: students) {

            if (st.getAge() < age){
                System.out.println(st);
            }
        }
    }

    void printStudentsMixCondition(List<Student> students, int age, double grade, char sex) {

        for (Student st: students) {

            if (st.getAge() > age && st.getAvgGrade() < grade && st.getSex() == sex){
                System.out.println(st);
            }
        }
    }

}

class Test{

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

        StudentInfo info = new StudentInfo();
        info.printStudentsOverGrade(students, 8);
        System.out.println("---");
        info.printStudentsUnderAge(students, 30);
        System.out.println("---");
        info.printStudentsMixCondition(students, 20, 9.5, 'f');
    }
}
