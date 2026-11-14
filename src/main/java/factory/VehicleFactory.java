package factory;

public class VehicleFactory {

    public static Vehicle createVehicle(String type, String model) {
        if (type.equalsIgnoreCase("car")) {
            return new Car(model);
        } else if (type.equalsIgnoreCase("bike")) {
            return new Bike(model);
        } else if (type.equalsIgnoreCase("van")) {
            return new Van(model);
        }
        System.out.println("Unknown vehicle type: " + type);
        return null;
    }
}