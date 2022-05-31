package stream.n58_grouping_partitioning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//метод .collect(Collectors.groupingBy(интерфейс Function )) возвращает Map<K, List<T>>

public class TestGrouping {

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

        //Сделать имена в верхнем регистре, сгруппировать по факультетам, в лямбда-выражении указываем поле группировки
        Map<Integer, List<Student>> map = students.stream()
                .map(el -> {
                    el.setName(el.getName().toUpperCase());
                    return el;
                })
                .collect(Collectors.groupingBy(el -> el.getCourse()));

        System.out.println(map);
        System.out.println("---------");

        //Корректный вывод мапы
        for (Map.Entry<Integer, List<Student>> entry: map.entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }

//        Вывод:
//        1: [Student{name='ELENA', sex=f, age=19, course=1, avgGrade=8.9}]
//        2: [Student{name='NIKOLAY', sex=m, age=28, course=2, avgGrade=6.4}]
//        3: [Student{name='IVAN', sex=m, age=22, course=3, avgGrade=8.3}, Student{name='MARYA', sex=f, age=23, course=3, avgGrade=7.4}]
//        4: [Student{name='PETR', sex=m, age=35, course=4, avgGrade=7.0}]
    }
}
