package lambda.n45_consumer;

import java.util.List;

public class ForEach {

    public static void main(String[] args) {

        List<String> list = List.of("privet", "poka", "kak dela?", "normalno");

        for (String s: list) {

            System.out.println(s);
        }

        System.out.println("---------");

        list.forEach(str -> System.out.println(str));
        System.out.println("---------");

        List<Integer> listInt = List.of(1, 2, 3, 4, 5);
        listInt.forEach(el -> {
            System.out.println(el);
            el = el * 2;
            System.out.println(el);
        });


    }

}
