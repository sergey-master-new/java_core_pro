package multithreading.n66_creat_thread;

public class Test4Runnable implements Runnable {

    public void run(){

        for (int i = 0; i <= 1000; i++){

            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        Thread thread2 = new Thread(new Test4Runnable());
        thread2.start();

        for (int i = 1000; i >= 0; i--){

            System.out.println(i);
        }
//        2 потока main, thread2
    }
}

