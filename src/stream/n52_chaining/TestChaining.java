package stream.n52_chaining;

import java.util.Arrays;

public class TestChaining {

    public static void main(String[] args) {


        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};

        int resultSum = Arrays.stream(array).filter(e -> e % 2 == 1)
                .map(e -> {
                    if (e % 3 == 0) {
                        e = e / 3;
                    }
                    return e;
                })
                .reduce((a, e) -> a + e).getAsInt();
        System.out.println(resultSum);

        //3 1 5 9 21 81 7
        //1 1 5 3 7 27 7 = сумма 51
        System.out.println("-------------------");

    }
}
