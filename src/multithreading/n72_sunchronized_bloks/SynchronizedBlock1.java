package multithreading.n72_sunchronized_bloks;

public class SynchronizedBlock1 {

    public static void main(String[] args) {

        Runnable1 runnable = new Runnable1(); //синхронизация будет вестись на объекте runnable
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter1{

    volatile static int count = 0;
}

class Runnable1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++){
            doWork1();
        }
    }

    private void doWork2(){
        System.out.println("Ura!!!");
    }

    public void doWork1(){
        doWork2();
        synchronized(this) {
            Counter1.count++;
            System.out.println(Counter1.count);
        }
    }
}
