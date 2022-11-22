package multithreading.n71_data_race_synhronized_method;

public class Test3Multithreading {

    public static void main(String[] args) {

        Runnable1 runnable = new Runnable1();
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
            increment();
        }
    }

    public synchronized void increment(){
        Counter1.count++;
        System.out.print(Counter1.count + " ");
    }
}
