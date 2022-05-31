package lambda.n45_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestConsumer {

    public static void main(String[] args) {

        List <Car> ourCars = createCars(3, () ->
                new Car("Nissan Tiida", "black", 1.6));

        System.out.println("Our cars:" + ourCars);
        System.out.println("----------------");

        changeCar(ourCars.get(0), car -> {
            car.setColor("yellow");
            car.setEngine(2.4);
            System.out.println(car);
        });

        System.out.println("Our cars:" + ourCars);
        System.out.println("----------------");


    }

    public static void changeCar(Car car, Consumer<Car> carConsumer){

        carConsumer.accept(car);
    }

    public static List<Car> createCars(int countCars, Supplier<Car> carSupplier){

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < countCars; i++){

            carList.add(carSupplier.get());
        }

        return carList;
    }
}

class Car{

    private String model;
    private String color;
    private double engine;

    public Car(String model, String color, double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}

