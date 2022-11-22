package multithreading.n74_deadlock;

//        Предотвращение ситуации deadlock-а
//        При вложенных синхронизированных блоках в нескольких потоках нужно
//        соблюдать одинаковую очередность объектов для блокирования (lock-ов) во всех потоках

public class DeadLockExample {

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

}

class Thread1 extends Thread{

    public void run(){
        System.out.println("Thread1: попытка захватить монитор объекта lock1");
        synchronized (DeadLockExample.lock1){
            System.out.println("Thread1: монитор объекта lock1 захвачен");
            System.out.println("Thread1: попытка захватить монитор объекта lock2");
            synchronized (DeadLockExample.lock2){
                System.out.println("Thread1: мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}

class Thread2 extends Thread{

    public void run(){
        System.out.println("Thread2: попытка захватить монитор объекта lock2");
        synchronized (DeadLockExample.lock2){
            System.out.println("Thread2: монитор объекта lock2 захвачен");
            System.out.println("Thread2: попытка захватить монитор объекта lock1");
            synchronized (DeadLockExample.lock1){
                System.out.println("Thread2: мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}
