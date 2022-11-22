package multithreading.n81_callable_future_2;

import java.util.concurrent.*;

public class RunnableFactorial2 {

    static int factorialResult;

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial4 factorial4 = new Factorial4(6);

        Future future = executorService.submit(factorial4);
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS); //если не использовать, то factorialResult = 0
                                                                       // так как поток main дальше будет выполняться
        System.out.println(future.isDone());
        System.out.println(future.get());
        System.out.println("factorialResult = " + factorialResult);
    }
}

class Factorial4 implements Runnable{

    private int f;

    public Factorial4(int f){
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
        RunnableFactorial2.factorialResult = result;
    }
}