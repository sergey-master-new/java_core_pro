package multithreading.n68_sleep_join;

public class Test1Sleep {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 5; i > 0; i--){

            System.out.println(i);
            Thread.sleep(1000); //в милисекундах
        }

        System.out.println("Поехали!!!");
    }
}

//Thread states:
//new - когда он создан
//runnable - когда запущен метод старт
//terminated - когда поток завершил свою работу