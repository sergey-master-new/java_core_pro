package multithreading.n81_callable_future_2;

import java.util.concurrent.*;

public class CallableFactorial2 {

    static int factorialResult;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial3 factorial3 = new Factorial3(6);

        Future<Integer> future = executorService.submit(factorial3);
        try{
            System.out.println(future.isDone());
            System.out.println("Хотим получить результат");
            factorialResult = future.get();
            System.out.println("Получили результат");
            System.out.println(future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            executorService.shutdown();
        }

        System.out.println("factorialResult = " + factorialResult);
    }
}

class Factorial3 implements Callable<Integer> {

    int f;

    public Factorial3(int f){
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {

        if (f <= 0){
            throw new Exception("Вы ввели неверное число");
        }

        int result = 1;
        for (int i = 1; i <= f; i++){
            result *=i;
            Thread.sleep(1000);
        }

        return result;
    }
}
