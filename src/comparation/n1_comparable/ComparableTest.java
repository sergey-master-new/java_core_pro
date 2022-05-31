package comparation.n1_comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Roman");
        list.add("Igor");
        list.add("Maria");
        list.add("Anton");
        System.out.println("Before sorting: " + list);

        // Сортировка по естественному порядку - natural order.
        // Для String по алфавиту, для int по возрастанию
        Collections.sort(list);
        System.out.println("After sorting: " + list);



    }
}
