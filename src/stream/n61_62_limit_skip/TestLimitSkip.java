package stream.n61_62_limit_skip;

import java.util.ArrayList;
import java.util.List;

//Stream<T> limit(long maxSize);
//Stream<T> skip(long n);

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

         students.stream().filter(el -> el.getAge() > 20).forEach(System.out::println);
         System.out.println();

         System.out.println("Limit 2 element:");
         students.stream().filter(el -> el.getAge() > 20).limit(2).forEach(System.out::println);
         System.out.println();

         System.out.println("Skip 2 element:");
         students.stream().filter(el -> el.getAge() > 20).skip(2).forEach(System.out::println);
     }
}
