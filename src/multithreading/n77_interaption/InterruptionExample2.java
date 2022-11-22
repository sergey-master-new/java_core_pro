package multithreading.n77_interaption;

public class InterruptionExample2 {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Main starts");
        InterruptedThread1 thread = new InterruptedThread1();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();

        thread.join();
        System.out.println("Main ends");
    }
}

class InterruptedThread1 extends Thread {

    double sqrtSum = 0;
    public void run() {
        for (int i = 1; i <= 1_000_000_000; i++) {
            if (isInterrupted()){
                System.out.println("Поток хотят прервать");
                System.out.println("Мы убедились, что состояние всех объектов нормальное, " +
                        "и решили завершить работу потока");
                return;
            }
            sqrtSum += Math.sqrt(i);
        }
        System.out.println("sqrtSum = " + sqrtSum);
    }
}
