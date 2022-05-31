package lambda.n41_lambda_1;

public class Test3 {

    static void def(I i){
        System.out.println(i.abc("Privet"));
    }

    public static void main(String[] args){
        def((String str) -> {return str.length();});
    }

}

interface I{

    int abc(String s);
}
