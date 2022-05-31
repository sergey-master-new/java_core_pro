package stream.n53_concat;

import java.util.stream.Stream;

//<T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)

public class TestConcat {

    public static void main(String[] args) {

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream2 = Stream.of(6, 7, 8, 9, 10);

//        Стрим может использоваться один раз, иначе IllegalStateException
//        IllegalStateException: stream has already been operated upon or closed
//        Stream<Integer> stream3 = Stream.concat(stream1, stream1); - выдаст ошибку

        Stream<Integer> stream3 = Stream.concat(stream1, stream2);
        stream3.filter(el -> el > 3).forEach(System.out::println);

    }

}
