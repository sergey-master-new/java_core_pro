package lambda.n43_predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIf {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("poka");
        list.add("ok");
        list.add("Uchim Java");
        list.add("A imenno lambdas");

//        default boolean removeIf(Predicate<? super E> filter)

        list.removeIf(element -> element.length() < 5);
        System.out.println(list);

        Predicate<String> predicate = element -> element.length() < 7;
        list.removeIf(predicate);
        System.out.println(list);


    }
}
