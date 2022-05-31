package stream.n64_parallelstream;

import java.util.ArrayList;
import java.util.List;

public class TestParallelStream {

    //Перемножить числа от 1 до 1 млрд.
    //1, 2, 3, 4, 5 ... 1_000_000_000 sequential stream
    //1 ... 250_000_000             parellel stream для 1-го ядра
    //250_000_001 ... 500_000_000   parellel stream для 2-го ядра
    //500_000_001 ... 750_000_000   parellel stream для 3-го ядра
    //750_000_001 ... 1_000_000_000 parellel stream для 4-го ядра

    public static void main(String[] args) {

        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(5.0);
        list.add(1.0);
        list.add(0.25);

        double sumResult = list.stream().reduce((accumulator, element) -> accumulator + element).get();
        System.out.println("Sum stream: " + sumResult);
        System.out.println("-------");

        double sumResultParallel = list.parallelStream().reduce((accumulator, element) -> accumulator + element).get();
        System.out.println("Sum parallelStream: " + sumResultParallel);
        System.out.println("-------");

        //ответ 8.0
        double divisionResult = list.stream().reduce((accumulator, element) -> accumulator / element).get();
        System.out.println("Division stream: " + divisionResult);
        System.out.println("-------");

        //не верное выполнение
        //10 / 5 = 2
        //1 / 0.25 = 4
        //параллельный стрим объединяет результаты 2 / 4 = 0.5
        double divisionResultParallel = list.parallelStream().reduce((accumulator, element) -> accumulator / element).get();
        System.out.println("Division parallelStream wrong result: " + divisionResultParallel);
        System.out.println("-------");

    }
}
