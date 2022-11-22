package multithreading.n76_daemon_threads;

public class DaemonExample {

    public static void main(String[] args) {
        System.out.println("Main thread starts");

        UserThread userThread = new UserThread();
        userThread.setName("User thread");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setName("Daemon thread");
        daemonThread.setDaemon(true);            //если daemonThread.start(), а после daemonThread.setDaemon(true)
        userThread.start();                      //то в потоке main будет выброшен IllegalThreadStateException
        daemonThread.start();                    //Exception in thread "main" java.lang.IllegalThreadStateException
                                                 //и потоки daemonThread и userThread будут полностью выполнены
        System.out.println("Main thread ends");
    }
}

class UserThread extends Thread{

    public void run(){
        System.out.println(Thread.currentThread().getName() +
                " + is daemon: " + isDaemon());                  //this.isDaemon()
        for(char i = 'A'; i <= 'J'; i++){
            try{
                sleep(300);                                //this.sleep()
                System.out.print(i + " ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DaemonThread extends Thread{

    public void run(){
        System.out.println(Thread.currentThread().getName() +
                " + is daemon: " + isDaemon());                  //this.isDaemon()
        for(int i = 1; i < 100; i++){
            try{
                sleep(100);                                 //this.sleep()
                System.out.print(i + " ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
