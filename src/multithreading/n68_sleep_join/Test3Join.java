package multithreading.n68_sleep_join;

public class Test3Join extends Thread{

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

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new MyRunnable1());
        Test2Sleep thread2 = new Test2Sleep();

        thread1.start();
        thread2.start();

        thread1.join(); // поток, в котором вызван метод join(), будет ждать выполнение потока, вызвавшего jon()
        thread2.join(); // join() вызван в поток main, поэтому main ждет выполнения thread2, после продолжает работу
        System.out.println("Конец!");
    }
}

class MyRunnable1 implements Runnable{

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
