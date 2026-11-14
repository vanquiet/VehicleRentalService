package factory;

public class Bike extends Vehicle {

    public Bike(String model) {
        super(model, 800, 5000);
    }

    @Override
    public String getType() {
        return "Bike";
    }
}
