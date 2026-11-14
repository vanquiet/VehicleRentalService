package factory;

public class Car extends Vehicle {

    public Car(String model) {
        super(model, 3000, 20000);
    }

    @Override
    public String getType() {
        return "Car";
    }
}
