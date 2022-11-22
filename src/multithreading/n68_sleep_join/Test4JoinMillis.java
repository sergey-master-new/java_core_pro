package multithreading.n68_sleep_join;

public class Test4JoinMillis {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Method main begins");
        Thread thread = new Thread(new Worker2());
        thread.start();
        thread.join(1500);
//        thread.join(4000);

        System.out.println("Method main ends");
    }

}

class Worker implements Runnable {

    @Override
    public void run() {

        System.out.println("Work begins");

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Work ends");
    }
}