package lambda.n42_lambda_2;

public class Test5 {

    static void def(Itest5 i) {
        System.out.println(i.abc("Privet"));
    }

    public static void main(String[] args) {

        int i = 10;
//        i = 15; не можем менять,
//        так как в анонимном методе может использоваться только effectivly final

        def((String str) -> {
            int j = 1;
            j = 100;
            return str.length() + i + j;
        });
    }

}

interface Itest5 {

    int abc(String s);
}
