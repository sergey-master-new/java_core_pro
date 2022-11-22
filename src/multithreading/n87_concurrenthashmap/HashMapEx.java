package multithreading.n87_concurrenthashmap;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapEx {

    public static void main(String[] args) throws InterruptedException {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Roma");
        map.put(2, "Oleg");
        map.put(3, "Sergey");
        map.put(4, "Ivan");
        map.put(5, "Igor");

        Runnable runnable1 = () -> {

            Iterator<Integer> iterator = map.keySet().iterator(); //у map iterator-а нет, поэтому получаем множество ключей
            while (iterator.hasNext()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = iterator.next();
                System.out.println(i + ":" + map.get(i));
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(6, "Elena");
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Map: " + map);
    }
}
