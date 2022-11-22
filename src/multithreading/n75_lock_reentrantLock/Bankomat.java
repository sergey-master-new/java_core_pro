package multithreading.n75_lock_reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bankomat {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        new Employee("Roma", lock);
        new Employee("Yan", lock);
        new Employee("Vitia", lock);
        new Employee("Katya", lock);
        new Employee("Sasha", lock);

    }
}

class Employee extends Thread{
    private String name;
    private Lock lock;

    Employee(String name, Lock lock){
        this.name = name;
        this.lock = lock;
        this.start();
    }

    public void run(){

        try {
            System.out.println(name + " ждет ...");
            lock.lock();
            System.out.println(name + " пользуется банкоматом");
            Thread.sleep(2000);
            System.out.println(name + " завершил работу с банкоматом");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
