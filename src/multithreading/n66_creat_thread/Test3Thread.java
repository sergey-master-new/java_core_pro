package multithreading.n66_creat_thread;

public class Test3Thread extends Thread {

    public void run() {

        for (int i = 0; i <= 1000; i++) {

            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        Test3Thread thread1 = new Test3Thread();
        thread1.start();

        for (int i = 1000; i >= 0; i--) {

            System.out.println(i);
        }

//        2 потока main, thread1
    }
}
