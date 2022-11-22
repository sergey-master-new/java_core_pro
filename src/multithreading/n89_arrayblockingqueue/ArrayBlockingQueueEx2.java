package multithreading.n89_arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueEx2 {

    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(4);

//      Producer
        new Thread(() -> {

            int i = 0;
            while (true) {
                try {
                    arrayBlockingQueue.put(++i);
                    System.out.println("Producer добавил " + i + " arrayBlockingQueue " + arrayBlockingQueue);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

//      Consumer
        new Thread(() -> {

            while (true) {
                try {
                    Integer j = arrayBlockingQueue.take();
                    System.out.println("Consumer забрал " + j + " arrayBlockingQueue " + arrayBlockingQueue);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
