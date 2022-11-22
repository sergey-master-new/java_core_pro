package multithreading.n79_scheduled_executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx4Scheduled {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);

        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl204(), 3, 1, TimeUnit.SECONDS);

        Thread.sleep(10000);
        scheduledExecutorService.shutdown();
        System.out.println("Main ends");

//        ExecutorService executorService = Executors.newCachedThreadPool();  newCachedThreadPool() создает потоки по мере
//                                                  необходимости, если в течении 60 сек нет заданий, закрывает все потоки
    }
}

class RunnableImpl204 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}
