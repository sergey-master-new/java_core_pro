package lambda.n46_function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StudentInfoFunction {

    public double getAvgOfSmth(List<Student> studentList, Function<Student, Double> function){

        double result = 0;

        for (Student st: studentList) {

            result += function.apply(st);
        }

        result = result / studentList.size();

        return result;
    }

}

class TestFunction {

    public static void main(String[] args) {

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Marya", 'f', 23, 3, 7.4);

        List<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfoFunction info = new StudentInfoFunction();

        //пример создания объекта анонимного класса интерфейса Function
        Function<Student, Double> function = student -> 3.14;

        double resAvg = info.getAvgOfSmth(students, student -> student.getAvgGrade());
        System.out.println("Average grade of students: " + resAvg);
        System.out.println("---------");

        resAvg = info.getAvgOfSmth(students, student -> Double.valueOf(student.getCourse()));
        System.out.println("Average course of students: " + resAvg);
        System.out.println("---------");

        resAvg = info.getAvgOfSmth(students, student -> (double) student.getAge());
        System.out.println("Average age of students: " + resAvg);
        System.out.println("---------");

    }

}
