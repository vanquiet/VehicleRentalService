package facade;

import builder.Rental;
import builder.RentalBuilder;
import decorator.BasicRental;
import decorator.ChildSeat;
import decorator.GPS;
import decorator.Insurance;
import decorator.RentalOption;
import factory.Vehicle;
import factory.VehicleFactory;
import observer.Customer;
import strategy.DailyPricing;
import strategy.HourlyPricing;
import strategy.PricingStrategy;

import java.util.ArrayList;

public class RentalFacade {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(String type, String model) {
        // create vehicle with factory
        Vehicle vehicle = VehicleFactory.createVehicle(type, model);
        if (vehicle != null) {
            vehicles.add(vehicle);
            System.out.println("Added " + vehicle.getType().toLowerCase() + ": " + model);
        }
    }

    public void showVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void subscribe(String model, Customer customer) {
        Vehicle vehicle = findVehicle(model);
        if (vehicle == null) {
            System.out.println("Vehicle not found: " + model);
            return;
        }
        vehicle.addObserver(customer);
        System.out.println(customer.getName() + " will be notified when " + model + " is available");
    }

    public Rental rentVehicle(String customerName, String model, int time, String priceType,
                              boolean insurance, boolean gps, boolean childSeat) {
        Vehicle vehicle = findVehicle(model);
        if (vehicle == null) {
            System.out.println("Vehicle not found: " + model);
            return null;
        }
        if (!vehicle.isAvailable()) {
            System.out.println("Sorry " + customerName + ", " + model + " is already rented");
            return null;
        }

        // choose pricing strategy
        PricingStrategy pricing;
        if (priceType.equalsIgnoreCase("hourly")) {
            pricing = new HourlyPricing();
        } else {
            pricing = new DailyPricing();
        }

        // build rental order
        Rental rental = new RentalBuilder()
                .setCustomer(customerName)
                .setVehicle(vehicle)
                .setTime(time)
                .setPricing(pricing)
                .setInsurance(insurance)
                .setGps(gps)
                .setChildSeat(childSeat)
                .build();
        if (rental == null) {
            return null;
        }

        // base price + extras with decorators
        int basePrice = pricing.calculatePrice(vehicle, rental.getTime());
        RentalOption option = new BasicRental(model + " for " + rental.getTime() + " "
                + pricing.getUnit() + " (" + basePrice + " tg)", basePrice);
        if (rental.hasInsurance()) {
            option = new Insurance(option);
        }
        if (rental.hasGps()) {
            option = new GPS(option);
        }
        if (rental.hasChildSeat()) {
            option = new ChildSeat(option);
        }

        rental.setDescription(option.getDescription());
        rental.setTotalPrice(option.getPrice());

        vehicle.setAvailable(false);
        rental.printInfo();
        return rental;
    }

    public void returnVehicle(String model) {
        Vehicle vehicle = findVehicle(model);
        if (vehicle == null) {
            System.out.println("Vehicle not found: " + model);
            return;
        }
        if (vehicle.isAvailable()) {
            System.out.println(model + " is not rented");
            return;
        }
        System.out.println(model + " was returned");
        // observers get notification here
        vehicle.setAvailable(true);
    }

    private Vehicle findVehicle(String model) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getModel().equalsIgnoreCase(model)) {
                return vehicle;
            }
        }
        return null;
    }
}
