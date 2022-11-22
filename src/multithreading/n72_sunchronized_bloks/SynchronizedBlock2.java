package multithreading.n72_sunchronized_bloks;

public class SynchronizedBlock2 {

    volatile static int counter = 0;

    public static void increment(){
        synchronized (SynchronizedBlock2.class) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new RunnableImpl());
        Thread thread2 = new Thread(new RunnableImpl());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Counter = " + counter);
    }
}

class RunnableImpl implements Runnable{

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++){
            SynchronizedBlock2.increment();
        }
    }
}