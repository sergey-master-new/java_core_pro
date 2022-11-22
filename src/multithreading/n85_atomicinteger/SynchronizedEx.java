package multithreading.n85_atomicinteger;

public class SynchronizedEx {

    static int counter = 0;

    public synchronized static void increment() {  //без synchronized сумма не всегда 200, иногда 170 и т.д.
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyRunnable10());
        Thread thread2 = new Thread(new MyRunnable10());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Сумма = " + counter);
    }
}

class MyRunnable10 implements Runnable {

    public void run(){
        for (int i = 0; i < 100; i++){
            SynchronizedEx.increment();
        }
    }
}