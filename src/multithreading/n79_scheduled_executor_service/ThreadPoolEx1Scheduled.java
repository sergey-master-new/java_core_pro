package multithreading.n79_scheduled_executor_service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadPoolEx1Scheduled {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);

        for (int i = 0; i < 10; i++){                                 //с execute() работает, как обычный ExecutorService
            scheduledExecutorService.execute(new RunnableImpl201());
        }

        scheduledExecutorService.shutdown();
        System.out.println("Main ends");
    }
}

class RunnableImpl201 implements Runnable{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}
