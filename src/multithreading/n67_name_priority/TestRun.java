package multithreading.n67_name_priority;

public class TestRun implements Runnable{

    @Override
    public void run() {

        System.out.println("Method run. Thread name = " +
                Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new TestRun());
//        thread.start();
        thread.run();

        System.out.println("Method main. Thread name = " +
                Thread.currentThread().getName());

    }
}
