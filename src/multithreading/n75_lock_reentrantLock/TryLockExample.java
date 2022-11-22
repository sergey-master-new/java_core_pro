package multithreading.n75_lock_reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        new Employee1("Roma", lock);
        new Employee1("Yan", lock);
        new Employee1("Vitia", lock);
        Thread.sleep(3000);
        new Employee1("Katya", lock);
        new Employee1("Sasha", lock);
    }
}

class Employee1 extends Thread {
    private String name;
    private Lock lock;

    Employee1(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    public void run() {

        if (lock.tryLock()) {
            try {
//                System.out.println(name + " ждет ...");
//                lock.lock();
                System.out.println(name + " пользуется банкоматом");
                Thread.sleep(2000);
                System.out.println(name + " завершил работу с банкоматом");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " не хочет ждать в очереди");
        }
    }
}