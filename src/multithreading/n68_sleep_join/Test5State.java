package multithreading.n68_sleep_join;

public class Test5State {


    public static void main(String[] args) throws InterruptedException {

        System.out.println("Method main begins");
        Thread thread = new Thread(new Worker2());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        thread.join();
//        thread.join(1500);
//        thread.join(4000);
        System.out.println(thread.getState());

        System.out.println("Method main ends");
    }

}

class Worker2 implements Runnable {

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
