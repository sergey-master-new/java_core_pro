package multithreading.n73_wait_notify;

public class WaitNotifyExample {

    public static void main(String[] args) {

        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}

class Market{

    private int countBread = 0;

    public synchronized void getBread(){
        while (countBread < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        countBread--;
        System.out.println("Потребитель купил 1 хлеб");
        System.out.println("Количество хлеба в магазине = " + countBread);
        notify();
    }

    public synchronized void putBread(){
        while (countBread >= 5){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        countBread++;
        System.out.println("Производитель добавил на витрину 1 хлеб");
        System.out.println("Количество хлеба в магазине = " + countBread);
        notify();
    }
}

class Producer implements Runnable{

    Market market;

    public Producer(Market market){
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            market.putBread();
        }
    }
}

class Consumer implements Runnable{

    Market market;

    public Consumer(Market market){
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            market.getBread();
        }
    }
}