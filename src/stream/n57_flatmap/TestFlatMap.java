package stream.n57_flatmap;

import java.util.ArrayList;
import java.util.List;

public class TestFlatMap {

    public static void main(String[] args) {

        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Marya", 'f', 23, 3, 7.4);

        Faculty faculty1 = new Faculty("Economics");
        Faculty faculty2 = new Faculty("Applied mathematics");

        faculty1.addStudent(st1);
        faculty1.addStudent(st2);
        faculty1.addStudent(st3);
        faculty2.addStudent(st4);
        faculty2.addStudent(st5);

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(faculty1);
        facultyList.add(faculty2);

        facultyList.stream().flatMap(faculty -> faculty.getStudentsOnFaculty().stream())
                .forEach(student -> System.out.println(student.getName()));


    }

}
