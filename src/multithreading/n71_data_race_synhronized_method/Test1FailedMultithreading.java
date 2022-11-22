package multithreading.n71_data_race_synhronized_method;

public class Test1FailedMultithreading {

    static int counter = 0;
    public static void increment(){
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Counter = " + counter);
    }
}

class R implements Runnable{

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++){
            Test1FailedMultithreading.increment();
        }
    }
}
