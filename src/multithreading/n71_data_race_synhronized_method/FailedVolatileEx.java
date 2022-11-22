package multithreading.n71_data_race_synhronized_method;

//Data Race - гонка данных, потоки участвуют в гонке


public class FailedVolatileEx {

    public static void main(String[] args) {

        MyRunnable1 runnable = new MyRunnable1();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter{

    volatile static int count = 0;
}

class MyRunnable1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++){
            increment();
        }
    }

    public void increment(){
        Counter.count++;
        System.out.print(Counter.count + " ");
    }
}
