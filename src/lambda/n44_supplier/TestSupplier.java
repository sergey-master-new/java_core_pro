package lambda.n44_supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TestSupplier {

    public static void main(String[] args) {

        List<Car> ourCars = createThreeCars( () ->
                new Car("Nissan Patrol", "red", 1.8));

        System.out.println("Our cars:" + ourCars);
        System.out.println("----------------");

        ourCars = createCars(5, () ->
                new Car("Nissan Tiida", "black", 1.6));

        System.out.println("Our cars:" + ourCars);
        System.out.println("----------------");
    }

    public static List<Car> createThreeCars(Supplier<Car> carSupplier){

        List<Car> carList = new ArrayList<>();

        for (int i = 0; i < 3; i++){

            carList.add(carSupplier.get());
        }

        return carList;
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
