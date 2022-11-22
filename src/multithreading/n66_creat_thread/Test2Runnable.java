package multithreading.n66_creat_thread;

public class Test2Runnable {

    public static void main(String[] args) {

    Thread myThread3 = new Thread(new MyThread3());
    Thread myThread4 = new Thread(new MyThread4());

    myThread3.start();
    myThread4.start();

//        3 потока main, myThread1, myThread2
}
}

class MyThread3 implements Runnable{

    public void run(){

        for (int i = 0; i <= 1000; i++){

            System.out.println(i);
        }
    }
}

class MyThread4 implements Runnable{

    public void run(){

        for (int i = 1000; i >= 0; i--){

            System.out.println(i);
        }
    }
}
