package multithreading.n68_sleep_join;

public class Test2Sleep extends Thread{

    public void run(){

        for (int i = 1; i < 10; i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new MyRunnable());
        Test2Sleep thread2 = new Test2Sleep();

        thread1.start();
        thread2.start();

        System.out.println("Конец!");
    }
}

class MyRunnable implements Runnable{

    public void run(){

        for (int i = 1; i < 10; i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}