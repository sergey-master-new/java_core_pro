package stream.n63_mapToInt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// IntStream mapToInt(ToIntFunction<? super T> mapper); также есть .mapToDouble(), .mapToLong()
// после mapToInt есть методы:
// int sum();
// OptionalDouble average();
// OptionalInt min();
// OptionalInt max();
// OptionalInt min();

public class TestLimitSkip {

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

         //boxed преобразует int в Integer
         List<Integer> courses = students.stream()
                 .mapToInt(el -> el.getCourse())
                 .boxed()
                 .collect(Collectors.toList());

         System.out.println(courses);
         System.out.println("-------------");

         int sumCourses = students.stream()
                 .mapToInt(el -> el.getCourse()).sum();

         System.out.println("Сумма курсов: " + sumCourses);
         System.out.println("-------------");

         //Возвращает OptionalDouble, нужна проверка, чтоб элементы были
         double averageCourse = students.stream()
                 .mapToInt(el -> el.getCourse()).average().getAsDouble();

         System.out.println("Средний курс студентов: " + averageCourse);
         System.out.println("-------------");

         //Возвращает OptionalInt, нужна проверка, чтоб элементы были
         int minCourse = students.stream()
                 .mapToInt(el -> el.getCourse()).min().getAsInt();

         System.out.println("Мин курс: " + minCourse);
         System.out.println("-------------");

         //Возвращает OptionalInt, нужна проверка, чтоб элементы были
         int maxAge = students.stream()
                 .mapToInt(el -> el.getAge()).max().getAsInt();

         System.out.println("Макс возраст студента: " + maxAge);
         System.out.println("-------------");

         List<Double> avgGrades = students.stream()
                 .mapToDouble(el -> el.getAvgGrade())
                 .boxed()
                 .collect(Collectors.toList());

         System.out.println(avgGrades);
     }
}

