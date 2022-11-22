package multithreading.n80_callable_future;

import java.util.concurrent.*;

public class CallableFactorial {

    static int factorialResult;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial2 factorial2 = new Factorial2(6);

        Future<Integer> future = executorService.submit(factorial2);
        try{
            factorialResult = future.get();
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

class Factorial2 implements Callable<Integer> {

    int f;

    public Factorial2(int f){
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
        }

        return result;
    }
}
