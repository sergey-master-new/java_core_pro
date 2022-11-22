package multithreading.n80_callable_future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunnableFactorial {

    static int factorialResult;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(6);
        executorService.execute(factorial);
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS); //если не использовать, то factorialResult = 0
                                                                      // так как поток main дальше будет выполняться
        System.out.println("factorialResult = " + factorialResult);
    }
}

class Factorial implements Runnable{

    private int f;

    public Factorial(int f){
        this.f = f;
    }

    @Override
    public void run() {

        if (f <= 0){

            System.out.println("Вы ввели неверное число");
            return;
        }

        int result = 1;
        for (int i = 1; i <= f; i++){
            result *= i;
        }
        RunnableFactorial.factorialResult = result;
    }
}