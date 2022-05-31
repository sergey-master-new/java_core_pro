package stream.n49_foreach;

import java.util.Arrays;

public class TestForEach {

    public static void main(String[] args) {

        int[] array = {5, 9, 3, 8, 1};

        Arrays.stream(array).forEach(el -> {
            el = el * 2;
            System.out.println(el);
        });
        System.out.println("---------");

        Arrays.stream(array).forEach(el -> System.out.println(el));
        System.out.println("---------");

        //method reference - мы даем ссылку на метод println - то есть каждый элемент нужно вставить в метод println
        Arrays.stream(array).forEach(System.out::println);
        System.out.println("---------");

        //другими словами, каждый элемент потока помести в метод processAndPrintElement
        Arrays.stream(array).forEach(Utils::processAndPrintElement);

    }

}

class Utils{

    public static void processAndPrintElement(int a){

        a = a + 5;
        System.out.println("Element: " + a);
    }
}
