package multithreading.n82_semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {

    public static void main(String[] args) {

        Semaphore callBox = new Semaphore(2);

        new Person("Roma", callBox);
        new Person("Anna", callBox);
        new Person("Sasha", callBox);
        new Person("Masha", callBox);
        new Person("Luis", callBox);

    }
}

class Person extends Thread {

    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    public void run() {

        try {

            System.out.println(name + " ждет ...");
            callBox.acquire();
            System.out.println(name + " пользуется телефоном");
//            sleep(2000);
            System.out.println(name + " завершил(а) звонок");

        } catch (InterruptedException e) {

            e.printStackTrace();

        } finally {

            callBox.release();
        }
    }
}