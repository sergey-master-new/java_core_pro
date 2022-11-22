package multithreading.n78_threadpool_executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolEx1 {

    public static void main(String[] args) {

//        ExecutorService executorService = new ThreadPoolExecutor();  так можно создать, но на практике исп. один из
//                                                                     фактори методов класса Executors (static methods)

        ExecutorService executorService = Executors.newFixedThreadPool(5); // возвращает return new ThreadPoolExecutor(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 10; i++){
            executorService.execute(new RunnableImpl100());
        }
        System.out.println("Main ends");
    }
}

class RunnableImpl100 implements Runnable{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " object : " + this);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


