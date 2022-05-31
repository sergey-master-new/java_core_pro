package nested_classes.n38_inner_class;

public class Car {

    private String color;
    private int doorCount;
    private Engine engine;


    public Car(String color, int doorCount) {
        Engine engine = new Engine(150);
        System.out.println(engine.horsePower);
        this.color = color;
        this.doorCount = doorCount;
//        this.engine = this.new Engine(horsePower);
    }

    public void setEngine(Engine engine){

        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }



    public class Engine {
        private int horsePower;
        private static final int A = 5;

        public Engine(int horsePower) {

            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "My engine: {" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test {

    public static void main(String[] args) {

        Car car = new Car("black", 4);
        Car.Engine engine = car.new Engine(256);
        car.setEngine(engine);

//      Редко используется следующий конструктор,
//      т.к. остается не известной ссылка на внешний класс Car:
        Car.Engine engine2 = new Car("red", 5).new Engine(256);

        System.out.println(engine);
        System.out.println(car);
    }
}