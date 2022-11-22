package multithreading.n77_interaption;

public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main starts");
        InterruptedThread thread = new InterruptedThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();             //посылается сигнал, что поток хотят прервать, но в потоке InterruptedThread
                                        //этот сигнал никак не обрабатывается и поток полностью отрабатывает
        thread.join();
        System.out.println("Main ends");
    }
}

class InterruptedThread extends Thread{

    double sqrtSum = 0;
    public void run(){
        for (int i = 1; i <= 1_000_000_000; i++){
            sqrtSum += Math.sqrt(i);
        }
        System.out.println("sqrtSum = " + sqrtSum);
    }
}
