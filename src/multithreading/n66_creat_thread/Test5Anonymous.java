package multithreading.n66_creat_thread;

public class Test5Anonymous {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Privet");
            }
        }).start();

        new Thread(() -> System.out.println("privet")).start();
    }
}
