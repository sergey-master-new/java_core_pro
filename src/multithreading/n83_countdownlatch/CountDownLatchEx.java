package multithreading.n83_countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {

    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void marketStaffIsOnPlace() throws InterruptedException {

        Thread.sleep(2000);
        System.out.println("Market staff came to work");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    private static void everythingtIsReady() throws InterruptedException {

        Thread.sleep(3000);
        System.out.println("Everything is ready, so let's open market");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    private static void openMarket() throws InterruptedException {

        Thread.sleep(4000);
        System.out.println("Market is opened");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {

        new Friend("Roma", countDownLatch);
        new Friend("Anna", countDownLatch);
        new Friend("Sasha", countDownLatch);
        new Friend("Masha", countDownLatch);
        new Friend("Luis", countDownLatch);

        marketStaffIsOnPlace();
        everythingtIsReady();
        openMarket();
    }
}

class Friend extends Thread{

    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch){
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    public void run(){

        try {
            countDownLatch.await();
            System.out.println(name + " приступил(а) к покупкам");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}