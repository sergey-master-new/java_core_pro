package stream.n57_flatmap;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

    private String name;
    List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        this.studentsOnFaculty = new ArrayList<>();
    }

    public void addStudent(Student student){

        studentsOnFaculty.add(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }

    public void setStudentsOnFaculty(List<Student> studentsOnFaculty) {
        this.studentsOnFaculty = studentsOnFaculty;
    }
}
