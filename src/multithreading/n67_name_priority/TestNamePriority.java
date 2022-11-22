package multithreading.n67_name_priority;

public class TestNamePriority {

    public static void main(String[] args) {

        MyThread5 myThread5 = new MyThread5();
        System.out.println("Name by thread: " + myThread5.getName() + " priority: " + myThread5.getPriority());

        MyThread5 myThread6 = new MyThread5();
        myThread6.setName("MegaThread");
        myThread6.setPriority(Thread.MAX_PRIORITY); //myThread6.setPriority(10);

        System.out.println("Name by thread: " + myThread6.getName() + " priority: " + myThread6.getPriority());
    }
}

class MyThread5 extends Thread {

    public void run() {

        for (int i = 0; i <= 1000; i++) {

            System.out.println(i);
        }
    }
}


