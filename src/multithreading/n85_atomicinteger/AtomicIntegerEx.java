package multithreading.n85_atomicinteger;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerEx {

    static AtomicInteger counter = new AtomicInteger(0); // 0 - по умолчанию, можно не указывать

    public static void increment() {
//        counter.incrementAndGet();
//        counter.getAndIncrement();
//        counter.addAndGet(5);
//        counter.getAndAdd(5);
//        counter.decrementAndGet();
//        counter.getAndDecrement();
        counter.getAndAdd(-5);
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyRunnable11());
        Thread thread2 = new Thread(new MyRunnable11());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Сумма = " + counter);
    }
}

class MyRunnable11 implements Runnable {

    public void run(){
        for (int i = 0; i < 100; i++){
            AtomicIntegerEx.increment();
        }
    }
}

