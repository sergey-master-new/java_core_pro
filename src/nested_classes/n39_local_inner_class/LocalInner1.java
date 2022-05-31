package nested_classes.n39_local_inner_class;

public class LocalInner1 {

    public static void main(String[] args) {

        Math math = new Math();
        math.getResult(21, 4);
    }
}

class Math {
    private int a = 10;

    public void getResult(final int delimoe, final int delitel) {

        class Divide {

            public int getChastnoe() {

                return delimoe / delitel;
            }

            public int getOstatok() {

//                тест видимости private переменных
//                внешнего класса
                System.out.println("A = " + a);
                return delimoe % delitel;
            }
        }

        Divide divide = new Divide();

        System.out.println("Delimoe = " + delimoe);
        System.out.println("Delitel = " + delitel);
        System.out.println("Chastnoe = " + divide.getChastnoe());
        System.out.println("Ostatok = " + divide.getOstatok());
    }
}
