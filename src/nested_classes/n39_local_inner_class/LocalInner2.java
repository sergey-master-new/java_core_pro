package nested_classes.n39_local_inner_class;

public class LocalInner2 {

    public static void main(String[] args) {

        class Summ implements Math2{

            @Override
            public int doOperation(int a, int b){
                return a + b;
            }
        }

        Summ summ = new Summ();

        System.out.println(summ.doOperation(3, 5));
    }
}

interface Math2{

    int doOperation(int a, int b);
}
