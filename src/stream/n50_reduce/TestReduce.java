package stream.n50_reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestReduce {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        //Optional<T> reduce(BinaryOperator<T> accumulator)
        //возвращает Optional, @NotNull
        int result = list.stream().reduce((accumulator, element) ->
                accumulator * element).get();
        //5, 8, 2, 4, 3. Сначала аккумулятору присваивается первый элемент, element-у - второй элемент
        //accumulator = 5  40  80  320  960
        //element =     8   2   4    3

        System.out.println(result);
        System.out.println("-------------");

        List<Integer> listEmpty = new ArrayList<>();
        //NoSuchElementException: No value present
//        result = listEmpty.stream().reduce((accumulator, element) ->
//                accumulator * element).get();


        Optional<Integer> opt = listEmpty.stream().reduce((accumulator, element) ->
                accumulator * element);
        if (opt.isPresent()){
            System.out.println(opt.get());
        } else {
            System.out.println("Not present elements and result");
        }
        System.out.println("-------------");


        //даже если list пуст, значение будет 1
        result = list.stream().reduce(1, (accumulator, element) ->
                accumulator * element);
        //5, 8, 2, 4, 3. Сначала аккумулятору присваивается 1 элемент, element-у - первый элемент
        //accumulator = 1  5  40  80  320  960
        //element =     5  8   2   4    3

        System.out.println(result);
        System.out.println("-------------");


        List<String> listString = new ArrayList<>();
        listString.add("privet");
        listString.add("kak dela?");
        listString.add("ok");
        listString.add("poka");

        String resultString = listString.stream().reduce((accum, el) -> accum + " " + el).get();
        System.out.println(resultString);

    }
}
