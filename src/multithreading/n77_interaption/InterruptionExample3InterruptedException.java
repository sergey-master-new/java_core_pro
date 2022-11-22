package multithreading.n77_interaption;

public class InterruptionExample3InterruptedException {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main starts");
        InterruptedThread2 thread = new InterruptedThread2();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();

        thread.join();
        System.out.println("Main ends");
    }
}

class InterruptedThread2 extends Thread {

    double sqrtSum = 0;
    public void run() {
        for (int i = 1; i <= 1_000_000_000; i++) {
            if (isInterrupted()){
                System.out.println("Поток хотят прервать");
                System.out.println("Мы убедились, что состояние всех объектов нормальное, " +
                        "и решили завершить работу потока");
                System.out.println("sqrtSum = " + sqrtSum);  //может сработать очень-очень редко, так как будет остановка попадать на сон
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Поток хотят прервать во время сна. " +
                        "Давайте завершим работу потока.");
                System.out.println("sqrtSum = " + sqrtSum);
                return;
            }
        }
        System.out.println("sqrtSum = " + sqrtSum);
    }
}
