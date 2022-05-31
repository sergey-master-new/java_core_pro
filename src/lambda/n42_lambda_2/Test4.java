package lambda.n42_lambda_2;

public class Test4 {

    static void def(Itest4 i){

        System.out.println(i.abc());
    }

    public static void main(String[] args){

        //если нет параметров, то пишем ()
        def(() -> {return 100;});
    }

}

interface Itest4 {

    int abc();
}
