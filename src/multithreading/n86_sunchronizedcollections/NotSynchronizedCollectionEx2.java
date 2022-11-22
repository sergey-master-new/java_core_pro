package multithreading.n86_sunchronizedcollections;

import java.util.ArrayList;
import java.util.Iterator;

public class NotSynchronizedCollectionEx2 {

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < 1000; i++){

            arrayList.add(i);
        }

        Runnable runnable1 = () -> {

            Iterator<Integer> iterator = arrayList.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        };

        Runnable runnable2 = () -> {

            arrayList.remove(10);
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Список: " + arrayList);
    }
}
