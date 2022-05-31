package stream.n47_map;

import java.util.*;
import java.util.stream.Collectors;

public class TestMap {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela?");
        list.add("ok");
        list.add("poka");

//        for (int i = 0; i < list.size(); i++){
//            list.set(i, String.valueOf(list.get(i).length()))
//        }

        //заменяем цикл выше, результат 6, 9, 2, 4
        List<Integer> listResult =
                list.stream().map(element -> element.length()).collect(Collectors.toList());
        System.out.println("List: " + listResult);

        //пример с массивом
        int[] array = {5, 9, 3, 8, 1};
        array = Arrays.stream(array).map(element -> {
            if (element % 3 == 0){
                element = element / 3;
            }
            return element;
        }).toArray();
        System.out.println("Array: " + Arrays.toString(array));

        //Стримы работают со всеми коллекциями, пример со множеством:
        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela?");
        set.add("ok");
        set.add("poka");
        System.out.println("Set до преобразования в int: " + set);

        Set<Integer> setResult = set.stream().map(e -> e.length()).collect(Collectors.toSet());
        System.out.println("Set: " + setResult);

        List<Integer> listResult2 = set.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println("List from set: " + listResult2);
    }
}
