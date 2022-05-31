package stream.n52_chaining;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class TestChainingListStudent {

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

        students.stream().map(el -> {
            el.setName(el.getName().toUpperCase());
            return el;
        })
                .filter(el -> el.getSex() == 'f')
                .sorted((x, y) -> x.getAge() - y.getAge())
                .forEach(el -> System.out.println(el));

        //мой пример с Optional, надо делать проверку isPresent()
        //выдает ошибку, если тип результата и тип элементов должен не совпадает в reduce, поэтому преобразовывал
        //студентов в double

        Optional<Double> sumGradeManOpt = students.stream()
                .filter(el -> el.getSex() == 'm')
                .map(el -> {
                    double avg = el.getAvgGrade();
                    return avg;
                })
                .reduce((accumulator, el) -> accumulator + el);

        Long countMan = students.stream().filter(el -> el.getSex() == 'm').count();

        if (sumGradeManOpt.isPresent()){
            System.out.println("Среднее арифметическая оценка у мужчин: " + sumGradeManOpt.get() / countMan);
        } else {
            System.out.println("Среди студентов мужчин нет");
        }
        System.out.println("-------------");

        //без Optional
        double sumGradeMan = students.stream()
                .filter(el -> el.getSex() == 'm')
                .map(el -> {
                    double avg = el.getAvgGrade();
                    return avg;
                })
                .reduce((double) 0, (accumulator, el) -> accumulator + el);

        if (countMan != 0) {
            System.out.println("Среднее арифметическая оценка у мужчин: " + sumGradeManOpt.get() / countMan);
        }
    }

}

class Student {

    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
