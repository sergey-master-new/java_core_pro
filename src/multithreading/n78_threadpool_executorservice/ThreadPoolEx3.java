package multithreading.n78_threadpool_executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolEx3 {

    public static void main(String[] args) {

    ExecutorService executorService = Executors.newFixedThreadPool(5);
    Thread thread = new Thread(new RunnableImpl103());
    for (int i = 0; i < 10; i++){
        executorService.execute(thread);
    }
    System.out.println("Main ends");
}
}

class RunnableImpl103 implements Runnable{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " object:" + this);
    }
}
