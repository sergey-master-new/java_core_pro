package multithreading.n86_sunchronizedcollections;

import java.util.ArrayList;

public class NotSynchronizedCollectionEx1 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> source = new ArrayList<>();

        for(int i = 0; i < 5; i++){

            source.add(i);
        }

        ArrayList<Integer> target = new ArrayList<>();

        Runnable runnable = () -> {
            target.addAll(source);
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Целевой список: " + target);
    }
}
