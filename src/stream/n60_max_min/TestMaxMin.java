package stream.n60_max_min;

import java.util.ArrayList;
import java.util.List;

//Optional<T> min(Comparator<? super T> comparator);
//Optional<T> max(Comparator<? super T> comparator);

public class TestMaxMin {

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

         //Возвращает Optional, нужно проверять методом isPresent() прежде, чем вызвать get()
         Student studentMinAge = students.stream().min((x, y) -> x.getAge() - y.getAge()).get();
         System.out.println("Самый молодой студент: " + studentMinAge);

         Student studentMaxAge = students.stream().max((x, y) -> x.getAge() - y.getAge()).get();
         System.out.println("Самый старший студент: " + studentMaxAge);
     }
}
