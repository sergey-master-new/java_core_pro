package nested_classes.n37_static_nested_class;

public class Car {

    private String color;
    private int doorCount;
    private Engine engine;
    private static int countOfCars;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    void method() {
        System.out.println(Engine.countOfObjects);
        Engine engine1 = new Engine(100);
        System.out.println(engine1.horsePower);
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    interface I{
        void get();
    }

    public static class Engine {
        private int horsePower;
        private static int countOfObjects;

        public Engine(int horsePower) {

            this.horsePower = horsePower;
            countOfObjects++;
            System.out.println(countOfCars); //для примера доступа
//            System.out.println(doorCount); //для примера доступа - ошибка компиляции
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

        Car.Engine engine = new Car.Engine(256);
        System.out.println(engine);

        Car car = new Car("red", 4, engine);
        System.out.println(car);

// нельзя        Car.Engine engine = new сar.Engine(256);
    }
}

class Z extends Car.Engine{

    public Z(int horsePower) {
        super(horsePower);
    }
}


