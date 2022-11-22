package multithreading.n78_threadpool_executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolEx4Shutdown {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++){
            executorService.execute(new RunnableImpl104());
        }
        executorService.shutdown();
        System.out.println("Main ends");
    }
}

class RunnableImpl104 implements Runnable{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}
