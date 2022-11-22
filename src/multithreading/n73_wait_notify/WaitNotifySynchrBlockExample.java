package multithreading.n73_wait_notify;

public class WaitNotifySynchrBlockExample {

    public static void main(String[] args) {

        Market1 market = new Market1();
        Producer1 producer = new Producer1(market);
        Consumer1 consumer = new Consumer1(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}

class Market1 {

    private int countBread = 0;
    static final Object lock = new Object();

    public void getBread() {
        synchronized (lock) {
            while (countBread < 1) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            countBread--;
            System.out.println("Потребитель купил 1 хлеб");
            System.out.println("Количество хлеба в магазине = " + countBread);
            lock.notify();
        }
    }

    public void putBread() {
        synchronized (lock) {
            while (countBread >= 5) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            countBread++;
            System.out.println("Производитель добавил на витрину 1 хлеб");
            System.out.println("Количество хлеба в магазине = " + countBread);
            lock.notify();
        }
    }
}

class Producer1 implements Runnable {

    Market1 market;

    public Producer1(Market1 market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.putBread();
        }
    }
}

class Consumer1 implements Runnable {

    Market1 market;

    public Consumer1(Market1 market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}