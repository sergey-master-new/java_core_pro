package stream.n52_chaining;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestChainingLazy {

    public static void main(String[] args) {

        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5);

        //lazy без терминального метода не запустится
        intStream
                .filter(el -> {
                    System.out.println("???");
                    return el % 2 == 0;
                });

        Stream<Integer> intStream2 = Stream.of(1, 2, 3, 4, 5);
        intStream2
                .filter(el -> {
                    System.out.println("!!!");
                    return el % 3 == 0;
                })
                .collect(Collectors.toList());

    }
}
